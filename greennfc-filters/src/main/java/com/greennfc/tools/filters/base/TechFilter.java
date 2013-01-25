package com.greennfc.tools.filters.base;

import android.nfc.NfcAdapter;

import com.greennfc.tools.filters.GreenFilterAdapter;

public class TechFilter extends GreenFilterAdapter {

	protected TechFilter() {
	}

	@Override
	public String getAction() {
		return NfcAdapter.ACTION_TECH_DISCOVERED;
	}

}
