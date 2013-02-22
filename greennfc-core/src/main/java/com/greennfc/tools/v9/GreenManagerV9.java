package com.greennfc.tools.v9;

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

import com.greennfc.tools.api.IGreenBeam;
import com.greennfc.tools.api.IGreenIntentFilter;
import com.greennfc.tools.api.IGreenIntentRecieveMessage;
import com.greennfc.tools.api.IGreenIntentRecieveRecord;
import com.greennfc.tools.api.IGreenIntentWrite;
import com.greennfc.tools.api.IGreenManager;
import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.beans.GreenRecieveBean;
import com.greennfc.tools.api.beans.GreenWriteBean;
import com.greennfc.tools.exception.NoNdefServiceException;
import com.greennfc.tools.exception.WriteException;
import com.greennfc.tools.records.factory.GreenRecordFactory;
import com.greennfc.tools.records.ndef.ext.AndroidApplicationRecord;
import com.greennfc.tools.writers.factory.GreenWriterFactory;

class GreenManagerV9 implements IGreenManager {

	private NfcAdapter mAdapter;

	private static final String TAG = "NfcManager";
	private SparseArray<IntentFilter[]> filtersArray = new SparseArray<IntentFilter[]>();
	private SparseArray<PendingIntent> pendingIntentArray = new SparseArray<PendingIntent>();
	private static final String[][] techs = { { Ndef.class.getName() } };

	protected GreenManagerV9() {
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
	public <Record extends IGreenRecord> void register(Activity activity, GreenRecieveBean<Record> recieveConfig, IGreenBeam<Record> beamWriter, IGreenIntentFilter... greenfilters) {
		mAdapter = NfcAdapter.getDefaultAdapter(activity);

		initIntent(activity, greenfilters);
		if (recieveConfig != null) {
			manageIntent(recieveConfig);
		}
		if (beamWriter != null) {
			assert beamWriter.getWriters() != null && beamWriter.getWriters().size() > 0 : "You have to specify at least one IGreenWriter if you want to beam messages !";
			NdefRecord[] recordArray = new NdefRecord[beamWriter.getWriters().size() + (beamWriter.addAndroidApplicationRecord() ? 1 : 0)];
			int i = 0;
			for (GreenWriteBean<Record> writer : beamWriter.getWriters()) {
				if (!writer.getGreenWriter().isInit()) {
					writer.getGreenWriter().init(writer.getGreenRecord());
				}
				recordArray[i] = writer.getGreenWriter().getNdefRecord();
				if (writer.isForceReinit()) {
					writer.getGreenWriter().reset();
				}
				i++;
				if (beamWriter.addAndroidApplicationRecord()) {
					GreenWriterFactory.ANDROID_APPLICATION_WRITER.init(GreenRecordFactory.externalFactory().androidApplicationRecordInstance(activity));
					recordArray[i] = GreenWriterFactory.ANDROID_APPLICATION_WRITER.getNdefRecord();
					GreenWriterFactory.ANDROID_APPLICATION_WRITER.reset();
				}
			}
			mAdapter.enableForegroundNdefPush(activity, new NdefMessage(recordArray));
		}
	}

	public <Record extends IGreenRecord> void register(Activity activity, GreenRecieveBean<Record> recieveConfig, IGreenIntentFilter... greenfilters) {
		register(activity, recieveConfig, null, greenfilters);
	}

	public <Record extends IGreenRecord> void register(Activity activity, IGreenBeam<Record> beamWriter, IGreenIntentFilter... filters) {
		register(activity, null, beamWriter, filters);
	}

	public void register(Activity activity, IGreenIntentFilter... filters) {
		register(activity, null, null, filters);
	}

	public <Record extends IGreenRecord> void register(Activity activity, IGreenBeam<Record> beamWriter) {
		register(activity, null, beamWriter);
	}

	/*
	 * 
	 * APIS METHODS
	 */

	@SuppressWarnings("unchecked")
	public <Record extends IGreenRecord> void manageIntent(GreenRecieveBean<Record> recieveConfig) {
		final Intent intent = recieveConfig.getIntent();
		final IGreenIntentRecieveRecord<Record> recieveRecord = recieveConfig.getGreenIntentRecieveRecord();
		final IGreenIntentRecieveMessage recieveMessage = recieveConfig.getGreenIntentRecieveMessage();
		final IGreenParser parser = recieveConfig.getGreenParser();
		final boolean recordCallBack = recieveRecord != null;
		GreenMessage greenMessage = recordCallBack ? new GreenMessage() : null;
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

	public <Record extends IGreenRecord> void writeTag(final Context context, final Intent intent, final IGreenIntentWrite recieve, final boolean addAndroidApplicationRecord, final GreenWriteBean<Record>... writers) {
		Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
		final Ndef ndef = Ndef.get(tag);
		// final IGreenWriter<Record> writer, final Record record
		RecordAsynkTask<Record> recordTask = new RecordAsynkTask<Record>(ndef, recieve, addAndroidApplicationRecord, context, writers);
		EmptyAsynkTask<Record> emptyTask = new EmptyAsynkTask<Record>(ndef, recordTask, recieve);
		emptyTask.execute();
	}

	private void initIntent(Activity activity, IGreenIntentFilter... filters) {
		PendingIntent pendingIntent = PendingIntent.getActivity(activity, 0, new Intent(activity, activity.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

		int length = filters != null && filters.length > 0 ? filters.length : 1;
		IntentFilter[] intentFilters = new IntentFilter[length];
		IntentFilter ndefFilter = null;
		int compt = 0;
		if (filters != null && filters.length > 0) {
			for (IGreenIntentFilter filter : filters) {

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

	class EmptyAsynkTask<Record extends IGreenRecord> extends AsyncTask<Void, Void, Exception> {

		private final Ndef ndef;
		private final RecordAsynkTask<Record> taskWrite;
		private final IGreenIntentWrite recieve;

		public EmptyAsynkTask(Ndef ndef, RecordAsynkTask<Record> taskWrite, IGreenIntentWrite recieve) {
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

	class RecordAsynkTask<Record extends IGreenRecord> extends AsyncTask<Void, Void, Exception> {

		private final Ndef ndef;
		private final IGreenIntentWrite recieve;
		private final GreenWriteBean<Record>[] writers;
		private final boolean addAndroidApplicationRecord;
		private final Context context;

		public RecordAsynkTask(Ndef ndef, IGreenIntentWrite recieve, boolean addAndroidApplicationRecord, Context context, GreenWriteBean<Record>... writers) {
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
					GreenWriteBean<Record> writer = null;
					for (int i = 0; i < writers.length; i++) {
						writer = writers[i];
						if (!writer.getGreenWriter().isInit()) {
							writer.getGreenWriter().init(writer.getGreenRecord());
						}
						recordArray[i] = writer.getGreenWriter().getNdefRecord();
						if (writer.isForceReinit()) {
							writer.getGreenWriter().reset();
						}
					}
					if (addAndroidApplicationRecord) {
						GreenWriterFactory.ANDROID_APPLICATION_WRITER.init(GreenRecordFactory.externalFactory().androidApplicationRecordInstance(context));
						recordArray[writers.length] = GreenWriterFactory.ANDROID_APPLICATION_WRITER.getNdefRecord();
						GreenWriterFactory.ANDROID_APPLICATION_WRITER.reset();
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
