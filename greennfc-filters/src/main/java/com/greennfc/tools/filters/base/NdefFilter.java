package com.greennfc.tools.filters.base;

import android.nfc.NfcAdapter;

import com.greennfc.tools.filters.GreenFilterAdapter;

public class NdefFilter extends GreenFilterAdapter {

	protected NdefFilter() {
	}

	@Override
	public String getAction() {
		return NfcAdapter.ACTION_NDEF_DISCOVERED;
	}

}
