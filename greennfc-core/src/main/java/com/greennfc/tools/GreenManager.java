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
import com.greennfc.tools.api.IGreenManager;
import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;

class GreenManager implements IGreenManager<IGreenRecord> {

	private Activity activity;

	private NfcAdapter mAdapter;

	private static final String TAG = "NfcManager";
	private IntentFilter[] filters;
	private PendingIntent pendingIntent;
	String[][] techs = { { Ndef.class.getName() } };

	// private BroadcastReceiver reciever = new BroadcastReceiver() {
	//
	// @Override
	// public void onReceive(Context context, Intent intent) {
	// manageIntent(intent);
	// }
	// };

	public void register(Activity activity, IGreenIntentFilter... greenfilters) {
		this.activity = activity;
		mAdapter = NfcAdapter.getDefaultAdapter(this.activity);

		initIntent(greenfilters);
	}

	public void pause(Activity activity) {
		if (activity.equals(this.activity)) {
			mAdapter.disableForegroundDispatch(this.activity);
			// for (int i = 0; i < filters.length; i++) {
			// this.activity.unregisterReceiver(reciever);
			// }
		}

	}

	public void resume(Activity activity) {
		if (activity.equals(this.activity)) {
			mAdapter.enableForegroundDispatch(this.activity, pendingIntent, filters, techs);
			// for (IntentFilter filter : filters) {
			// this.activity.registerReceiver(reciever, filter);
			// }
		}

	}

	public void manageIntent(final Intent intent, final IGreenIntentRecieve<IGreenRecord> recieve, final IGreenParser parser) {
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

	public void writeTag(final Intent intent, final IGreenWriter writer) {
		Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
		final Ndef ndef = Ndef.get(tag);
		AsyncTask<Void, Void, String> taskWrite = new AsyncTask<Void, Void, String>() {

			@Override
			protected String doInBackground(Void... params) {
				if (ndef == null) {
					return null;
				}
				try {
					ndef.connect();

					try {
						// ndef.writeNdefMessage(writer.getMessageRecord(record));
					} catch (FormatException e) {
						Log.e("Error : ", e.getMessage(), e);
					}

				} catch (IOException e) {
					Log.e("Error : ", e.getMessage(), e);
				} finally {
					if (ndef != null) {
						try {
							ndef.close();
						} catch (IOException e) {
							Log.e("Error : ", e.getMessage(), e);
						}
					}
				}
				return "OK";
			}

			@Override
			protected void onPostExecute(String result) {
				if (result == null) {

					// writeMsg.setText("Write not OK !");
				} else {
					// writeMsg.setText("Write OK !");
				}
			}

		};
		taskWrite.execute();

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

					ndefFilter.addDataPath(filter.getDataType().charAt(0) == '/' ? filter.getDataPath() : "/" + filter.getDataPath() //
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

}
