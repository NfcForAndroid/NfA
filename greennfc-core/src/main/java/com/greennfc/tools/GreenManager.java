package com.greennfc.tools;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.tech.Ndef;
import android.os.Parcelable;
import android.os.PatternMatcher;
import android.util.Log;

import com.greennfc.tools.api.IGreenIntentFilter;
import com.greennfc.tools.api.IGreenManager;

class GreenManager implements IGreenManager {

	private Activity activity;

	private NfcAdapter mAdapter;

	private static final String TAG = "NfcManager";
	private IntentFilter[] filters;
	private PendingIntent pendingIntent;
	String[][] techs = { { Ndef.class.getName() } };

	private BroadcastReceiver reciever = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			manageIntent(intent);
		}
	};

	public void register(Activity activity) {
		this.activity = activity;
		mAdapter = NfcAdapter.getDefaultAdapter(this.activity);
	}

	public void pause(Activity activity) {
		if (activity.equals(this.activity)) {
			mAdapter.disableForegroundDispatch(this.activity);
			for (IntentFilter filter : filters) {
				this.activity.unregisterReceiver(reciever);
			}
		}

	}

	public void resume(Activity activity) {
		if (activity.equals(this.activity)) {
			mAdapter.enableForegroundDispatch(this.activity, pendingIntent, filters, techs);
			for (IntentFilter filter : filters) {
				this.activity.registerReceiver(reciever, filter);
			}
		}

	}

	public void manageIntent(Intent intent) {
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
						byte[] id = record.getId();
						short tnf = record.getTnf();
						byte[] type = record.getType();
						String message = new String(record.getPayload());
						Log.i(TAG, "Message : " + message);
					}
				}
			}
		}

	}

	public void initIntent(IGreenIntentFilter... filters) {
		pendingIntent = PendingIntent.getActivity(this.activity, 0, new Intent(this.activity, this.activity.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

		int length = filters != null && filters.length > 0 ? filters.length : 1;
		this.filters = new IntentFilter[length];
		IntentFilter ndefFilter = null;
		int compt = 0;
		if (filters != null && filters.length > 0) {
			for (IGreenIntentFilter filter : filters) {

				ndefFilter = new IntentFilter(filter.getAction());
				ndefFilter.addDataScheme("vnd.android.nfc");
				ndefFilter.addDataAuthority("ext", null);
				ndefFilter.addDataPath("/" + filter.getType(), PatternMatcher.PATTERN_LITERAL);

				this.filters[compt] = ndefFilter;
				compt++;
			}
		} else {
			ndefFilter = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
			this.filters[0] = ndefFilter;
		}
		manageIntent(this.activity.getIntent());
	}

}
