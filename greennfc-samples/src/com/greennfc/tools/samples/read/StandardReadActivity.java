package com.greennfc.tools.samples.read;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.tech.Ndef;
import android.os.Bundle;

import com.greennfc.tools.samples.R;

public class StandardReadActivity extends Activity {

	NfcAdapter adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read);
		adapter = NfcAdapter.getDefaultAdapter(this);
		resoudreIntent(getIntent());
	}

	@Override
	protected void onPause() {
		adapter.disableForegroundDispatch(this);
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, this.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
		IntentFilter ndefFilter = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
		IntentFilter[] filters = { ndefFilter };
		String[][] techs = { { Ndef.class.getName() } };
		adapter.enableForegroundDispatch(this, pendingIntent, filters, techs);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		resoudreIntent(intent);
	}

	private void resoudreIntent(Intent intent) {
		String action = intent.getAction();
		if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action) //
				|| NfcAdapter.ACTION_TECH_DISCOVERED.equals(action) //
				|| NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action) //
		) {

		}
	}

}
