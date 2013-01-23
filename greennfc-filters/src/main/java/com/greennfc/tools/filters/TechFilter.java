package com.greennfc.tools.filters;

import android.nfc.NfcAdapter;

public class TechFilter extends GreenFilterAdapter {

	@Override
	public String getAction() {
		return NfcAdapter.ACTION_TECH_DISCOVERED;
	}

}
