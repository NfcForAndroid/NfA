package com.greennfc.tools.filters.ndef;

import android.nfc.NfcAdapter;

import com.greennfc.tools.filters.GreenFilterAdapter;

public abstract class NdefFilter extends GreenFilterAdapter {

	@Override
	public String getAction() {
		return NfcAdapter.ACTION_NDEF_DISCOVERED;
	}

}
