package com.greennfc.tools;

import java.io.IOException;

import android.app.Activity;
import android.app.PendingIntent;
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

import com.greennfc.tools.api.IGreenIntentFilter;
import com.greennfc.tools.api.IGreenIntentRecieve;
import com.greennfc.tools.api.IGreenIntentWrite;
import com.greennfc.tools.api.IGreenManager;
import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;

class GreenManager implements IGreenManager {

	private Activity activity;

	private NfcAdapter mAdapter;

	private static final String TAG = "NfcManager";
	private IntentFilter[] filters;
	private PendingIntent pendingIntent;
	String[][] techs = { { Ndef.class.getName() } };

	public void register(Activity activity, IGreenIntentFilter... greenfilters) {
		this.activity = activity;
		mAdapter = NfcAdapter.getDefaultAdapter(this.activity);

		initIntent(greenfilters);
	}

	public void pause(Activity activity) {
		if (activity.equals(this.activity)) {
			mAdapter.disableForegroundDispatch(this.activity);
		}

	}

	public void resume(Activity activity) {
		if (activity.equals(this.activity)) {
			mAdapter.enableForegroundDispatch(this.activity, pendingIntent, filters, techs);
		}

	}

	public void manageIntent(final Intent intent, final IGreenIntentRecieve recieve, final IGreenParser parser) {
		Log.i(TAG, "Recieve Intent NFC ! ");

		String action = intent.getAction();
		if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action) //
		) {
			Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
			NdefMessage[] messages;
			NdefRecord record = null;
			if (rawMsgs != null) {
				messages = new NdefMessage[rawMsgs.length];
				for (int i = 0; i < rawMsgs.length; i++) {
					messages[i] = (NdefMessage) rawMsgs[i];
					for (int j = 0; j < messages[i].getRecords().length; j++) {
						record = messages[i].getRecords()[j];
						recieve.recieveMessage(parser.parseNdef(record));
					}
				}
			}
		} else {
			Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
			if (tag != null) {
				recieve.recieveMessage(parser.parseTag(tag));
			}
		}

	}

	public <Record extends IGreenRecord> void writeTag(final Intent intent, final IGreenIntentWrite recieve, final IGreenWriter<Record> writer, final Record record) {
		Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
		final Ndef ndef = Ndef.get(tag);
		RecordAsynkTask<Record> recordTask = new RecordAsynkTask<Record>(ndef, recieve, writer, record);
		EmptyAsynkTask<Record> emptyTask = new EmptyAsynkTask<Record>(ndef, recordTask, recieve);
		emptyTask.execute();
	}

	private void initIntent(IGreenIntentFilter... filters) {
		pendingIntent = PendingIntent.getActivity(this.activity, 0, new Intent(this.activity, this.activity.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

		int length = filters != null && filters.length > 0 ? filters.length : 1;
		this.filters = new IntentFilter[length];
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

				this.filters[compt] = ndefFilter;
				compt++;
			}
		} else {
			ndefFilter = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
			this.filters[0] = ndefFilter;
		}
		// manageIntent(this.activity.getIntent());
	}

	class EmptyAsynkTask<Record extends IGreenRecord> extends AsyncTask<Void, Void, String> {

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
		protected String doInBackground(Void... arg0) {
			if (ndef == null) {
				return null;
			}
			try {
				ndef.connect();

				try {
					ndef.writeNdefMessage(new NdefMessage(new NdefRecord[] { new NdefRecord(NdefRecord.TNF_EMPTY, null, new byte[0], null) }));
				} catch (FormatException e) {
					Log.e("Error : ", e.getMessage(), e);
					return null;
				}

			} catch (IOException e) {
				Log.e("Error : ", e.getMessage(), e);
				return null;
			} finally {
				if (ndef != null) {
					try {
						ndef.close();
					} catch (IOException e) {
						Log.e("Error : ", e.getMessage(), e);
						return null;
					}
				}
			}
			return "OK";
		}

		@Override
		protected void onPostExecute(String result) {
			if (result != null) {
				taskWrite.execute();
			}
		}

	}

	class RecordAsynkTask<Record extends IGreenRecord> extends AsyncTask<Void, Void, String> {

		private final Ndef ndef;
		private final IGreenIntentWrite recieve;
		private final IGreenWriter<Record> writer;
		private final Record record;

		public RecordAsynkTask(Ndef ndef, IGreenIntentWrite recieve, IGreenWriter<Record> writer, Record record) {
			super();
			this.ndef = ndef;
			this.recieve = recieve;
			this.writer = writer;
			this.record = record;
		}

		@Override
		protected String doInBackground(Void... arg0) {
			if (ndef == null) {
				return null;
			}
			try {
				ndef.connect();

				try {
					writer.init(record);
					ndef.writeNdefMessage(writer.getMessageRecord());
				} catch (FormatException e) {
					Log.e("Error : ", e.getMessage(), e);
					return null;
				}

			} catch (IOException e) {
				Log.e("Error : ", e.getMessage(), e);
				return null;
			} finally {
				if (ndef != null) {
					try {
						ndef.close();
					} catch (IOException e) {
						Log.e("Error : ", e.getMessage(), e);
						return null;
					}
				}
			}
			return "OK";
		}

		@Override
		protected void onPostExecute(String result) {
			recieve.messageWrite(result != null);
		}

	}

}
