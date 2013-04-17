package com.nfa.tools.v9;

import java.io.IOException;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.os.PatternMatcher;
import android.util.Log;
import android.util.SparseArray;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.api.INfaManager;
import com.nfa.tools.api.INfaParser;
import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.beans.NfaRecieveBean;
import com.nfa.tools.api.beans.NfaWriteBean;
import com.nfa.tools.api.client.INfaBeam;
import com.nfa.tools.api.client.INfaIntentRecieveMessage;
import com.nfa.tools.api.client.INfaIntentRecieveRecord;
import com.nfa.tools.api.client.INfaIntentWrite;
import com.nfa.tools.exception.NoNdefServiceException;
import com.nfa.tools.exception.WriteException;
import com.nfa.tools.records.factory.NfaRecordFactory;
import com.nfa.tools.records.ndef.ext.AndroidApplicationRecord;
import com.nfa.tools.writers.factory.NfaWriterFactory;

class NfaManagerV9 implements INfaManager {

	private NfcAdapter mAdapter;

	private static final String TAG = "NfcManager";
	private SparseArray<IntentFilter[]> filtersArray = new SparseArray<IntentFilter[]>();
	private SparseArray<PendingIntent> pendingIntentArray = new SparseArray<PendingIntent>();
	private static final String[][] techs = { { Ndef.class.getName() } };

	protected NfaManagerV9() {
		super();
	}

	/*
	 * 
	 * LIFE CYCLE METHODS
	 */

	public void pause(Activity activity) {
		mAdapter.disableForegroundDispatch(activity);
	}

	public void resume(Activity activity) {
		if (filtersArray.indexOfKey(activity.getTaskId()) != -1) {
			IntentFilter[] filters = filtersArray.get(activity.getTaskId());
			PendingIntent pendingIntent = pendingIntentArray.get(activity.getTaskId());
			mAdapter.enableForegroundDispatch(activity, pendingIntent, filters, techs);
		}

	}

	public void stop(Activity activity) {
		filtersArray.delete(activity.getTaskId());
		pendingIntentArray.delete(activity.getTaskId());
	}

	/*
	 * 
	 * INITS METHOD
	 */

	@SuppressWarnings("deprecation")
	public <Record extends INfaRecord> void register(Activity activity, NfaRecieveBean<Record> recieveConfig, INfaBeam<Record> beamWriter, INfaIntentFilter... greenfilters) {
		mAdapter = NfcAdapter.getDefaultAdapter(activity);

		initIntent(activity, greenfilters);
		if (recieveConfig != null) {
			manageIntent(recieveConfig);
		}
		if (beamWriter != null) {
			assert beamWriter.getWriters() != null && beamWriter.getWriters().size() > 0 : "You have to specify at least one IGreenWriter if you want to beam messages !";
			NdefRecord[] recordArray = new NdefRecord[beamWriter.getWriters().size() + (beamWriter.addAndroidApplicationRecord() ? 1 : 0)];
			int i = 0;
			for (NfaWriteBean<Record> writer : beamWriter.getWriters()) {
				if (!writer.getNfaWriter().isInit()) {
					writer.getNfaWriter().init(writer.getNfaRecord());
				}
				recordArray[i] = writer.getNfaWriter().getNdefRecord();
				if (writer.isForceReinit()) {
					writer.getNfaWriter().reset();
				}
				i++;
				if (beamWriter.addAndroidApplicationRecord()) {
					NfaWriterFactory.ANDROID_APPLICATION_WRITER.init(NfaRecordFactory.externalFactory().androidApplicationRecordInstance(activity));
					recordArray[i] = NfaWriterFactory.ANDROID_APPLICATION_WRITER.getNdefRecord();
					NfaWriterFactory.ANDROID_APPLICATION_WRITER.reset();
				}
			}
			mAdapter.enableForegroundNdefPush(activity, new NdefMessage(recordArray));
		}
	}

	public <Record extends INfaRecord> void register(Activity activity, NfaRecieveBean<Record> recieveConfig, INfaIntentFilter... greenfilters) {
		register(activity, recieveConfig, null, greenfilters);
	}

	public <Record extends INfaRecord> void register(Activity activity, INfaBeam<Record> beamWriter, INfaIntentFilter... filters) {
		register(activity, null, beamWriter, filters);
	}

	public void register(Activity activity, INfaIntentFilter... filters) {
		register(activity, null, null, filters);
	}

	public <Record extends INfaRecord> void register(Activity activity, INfaBeam<Record> beamWriter) {
		register(activity, null, beamWriter);
	}

	/*
	 * 
	 * APIS METHODS
	 */

	@SuppressWarnings("unchecked")
	public <Record extends INfaRecord> void manageIntent(NfaRecieveBean<Record> recieveConfig) {
		final Intent intent = recieveConfig.getIntent();
		final INfaIntentRecieveRecord<Record> recieveRecord = recieveConfig.getNfaIntentRecieveRecord();
		final INfaIntentRecieveMessage recieveMessage = recieveConfig.getNfaIntentRecieveMessage();
		final INfaParser parser = recieveConfig.getNfaParser();
		final boolean recordCallBack = recieveRecord != null;
		NfaMessage greenMessage = recordCallBack ? new NfaMessage() : null;
		Record greenRecord = null;
		Log.i(TAG, "Recieve Intent NFC ! ");

		String action = intent.getAction();
		boolean treat = false;
		if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action) //
				|| NfcAdapter.ACTION_TECH_DISCOVERED.equals(action) || NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)) {
			Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
			NdefMessage[] messages;
			NdefRecord record = null;
			if (rawMsgs != null) {
				treat = true;
				messages = new NdefMessage[rawMsgs.length];
				for (int i = 0; i < rawMsgs.length; i++) {
					messages[i] = (NdefMessage) rawMsgs[i];
					for (int j = 0; j < messages[i].getRecords().length; j++) {
						record = messages[i].getRecords()[j];
						greenRecord = (Record) parser.parseNdef(record);
						if (recordCallBack) {
							recieveRecord.recieveRecord(greenRecord);
						} else if (!recieveConfig.isAvoidAndroidApplicationRecord() || //
								!(greenRecord instanceof AndroidApplicationRecord) //
						) {
							greenMessage.addRecord(greenRecord);
						}
					}
				}
			}
		}

		if (!treat) {
			Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
			if (tag != null) {
				greenRecord = (Record) parser.parseTag(tag);
				if (recordCallBack) {
					recieveRecord.recieveRecord(greenRecord);
				} else {
					greenMessage.addRecord(greenRecord);
				}
			}
		}

		if (!recordCallBack) {
			recieveMessage.recieveMessage(greenMessage);
		}

	}

	public <Record extends INfaRecord> void writeTag(final Context context, final Intent intent, final INfaIntentWrite recieve, final boolean addAndroidApplicationRecord, final NfaWriteBean<Record>... writers) {
		Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
		final Ndef ndef = Ndef.get(tag);
		// final IGreenWriter<Record> writer, final Record record
		RecordAsynkTask<Record> recordTask = new RecordAsynkTask<Record>(ndef, recieve, addAndroidApplicationRecord, context, writers);
		EmptyAsynkTask<Record> emptyTask = new EmptyAsynkTask<Record>(ndef, recordTask, recieve);
		emptyTask.execute();
	}

	private void initIntent(Activity activity, INfaIntentFilter... filters) {
		PendingIntent pendingIntent = PendingIntent.getActivity(activity, 0, new Intent(activity, activity.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

		int length = filters != null && filters.length > 0 ? filters.length : 1;
		IntentFilter[] intentFilters = new IntentFilter[length];
		IntentFilter ndefFilter = null;
		int compt = 0;
		if (filters != null && filters.length > 0) {
			for (INfaIntentFilter filter : filters) {

				ndefFilter = new IntentFilter(filter.getAction());
				if (filter.getDataScheme() != null) {
					ndefFilter.addDataScheme(filter.getDataScheme());
				}
				if (filter.getDataAuthorityHost() != null) {
					ndefFilter.addDataAuthority(filter.getDataAuthorityHost(), filter.getDataAuthorityPort());
				}
				if (filter.getDataPath() != null) {

					ndefFilter.addDataPath(filter.getDataPath().charAt(0) == '/' ? filter.getDataPath() : "/" + filter.getDataPath() //
					, PatternMatcher.PATTERN_LITERAL);
				}
				if (filter.getDataType() != null) {
					try {
						ndefFilter.addDataType(filter.getDataType());
					} catch (MalformedMimeTypeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				intentFilters[compt] = ndefFilter;
				compt++;
			}
		} else {
			ndefFilter = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
			intentFilters[0] = ndefFilter;
		}

		filtersArray.put(activity.getTaskId(), intentFilters);
		pendingIntentArray.put(activity.getTaskId(), pendingIntent);
	}

	/*
	 * 
	 * ASYNTASKS FOR WRITE
	 */

	class EmptyAsynkTask<Record extends INfaRecord> extends AsyncTask<Void, Void, Exception> {

		private final Ndef ndef;
		private final RecordAsynkTask<Record> taskWrite;
		private final INfaIntentWrite recieve;

		public EmptyAsynkTask(Ndef ndef, RecordAsynkTask<Record> taskWrite, INfaIntentWrite recieve) {
			super();
			this.ndef = ndef;
			this.taskWrite = taskWrite;
			this.recieve = recieve;
		}

		@Override
		protected Exception doInBackground(Void... arg0) {
			if (ndef == null) {
				return new NoNdefServiceException("The tag has no Ndef capabilities");
			}
			try {
				ndef.connect();

				try {
					ndef.writeNdefMessage(new NdefMessage(new NdefRecord[] { new NdefRecord(NdefRecord.TNF_EMPTY, null, new byte[0], null) }));
				} catch (FormatException e) {
					Log.e("Error : ", e.getMessage(), e);
					return new WriteException(e);
				}

			} catch (IOException e) {
				Log.e("Error : ", e.getMessage(), e);
				return new WriteException(e);
			} finally {
				if (ndef != null) {
					try {
						ndef.close();
					} catch (IOException e) {
						Log.e("Error : ", e.getMessage(), e);
						return new WriteException(e);
					}
				}
			}
			return null;
		}

		@Override
		protected void onPostExecute(Exception result) {
			if (result == null) {
				taskWrite.execute();
			} else {
				recieve.messageWrite(false, result);
			}
		}

	}

	class RecordAsynkTask<Record extends INfaRecord> extends AsyncTask<Void, Void, Exception> {

		private final Ndef ndef;
		private final INfaIntentWrite recieve;
		private final NfaWriteBean<Record>[] writers;
		private final boolean addAndroidApplicationRecord;
		private final Context context;

		public RecordAsynkTask(Ndef ndef, INfaIntentWrite recieve, boolean addAndroidApplicationRecord, Context context, NfaWriteBean<Record>... writers) {
			super();
			this.ndef = ndef;
			this.recieve = recieve;
			this.writers = writers;
			this.addAndroidApplicationRecord = addAndroidApplicationRecord;
			this.context = context;
		}

		@Override
		protected Exception doInBackground(Void... arg0) {
			if (ndef == null) {
				return new NoNdefServiceException("The tag has no Ndef capabilities");
			}
			try {
				ndef.connect();

				try {
					NdefRecord[] recordArray = new NdefRecord[writers.length + (addAndroidApplicationRecord ? 1 : 0)];
					NfaWriteBean<Record> writer = null;
					for (int i = 0; i < writers.length; i++) {
						writer = writers[i];
						if (!writer.getNfaWriter().isInit()) {
							writer.getNfaWriter().init(writer.getNfaRecord());
						}
						recordArray[i] = writer.getNfaWriter().getNdefRecord();
						if (writer.isForceReinit()) {
							writer.getNfaWriter().reset();
						}
					}
					if (addAndroidApplicationRecord) {
						NfaWriterFactory.ANDROID_APPLICATION_WRITER.init(NfaRecordFactory.externalFactory().androidApplicationRecordInstance(context));
						recordArray[writers.length] = NfaWriterFactory.ANDROID_APPLICATION_WRITER.getNdefRecord();
						NfaWriterFactory.ANDROID_APPLICATION_WRITER.reset();
					}
					NdefMessage ndefMessage = new NdefMessage(recordArray);
					ndef.writeNdefMessage(ndefMessage);
				} catch (FormatException e) {
					Log.e("Error : ", e.getMessage(), e);
					return new WriteException(e);
				}

			} catch (IOException e) {
				Log.e("Error : ", e.getMessage(), e);
				return new WriteException(e);
			} finally {
				if (ndef != null) {
					try {
						ndef.close();
					} catch (IOException e) {
						Log.e("Error : ", e.getMessage(), e);
						return new WriteException(e);
					}
				}
			}
			return null;
		}

		@Override
		protected void onPostExecute(Exception result) {
			recieve.messageWrite(result == null, result);
		}

	}

}
