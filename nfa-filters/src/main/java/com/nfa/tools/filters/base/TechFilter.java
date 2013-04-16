package com.nfa.tools.filters.base;

import android.nfc.NfcAdapter;

import com.nfa.tools.filters.NfaFilterAdapter;

public class TechFilter extends NfaFilterAdapter {

	protected TechFilter() {
	}

	@Override
	public String getAction() {
		return NfcAdapter.ACTION_TECH_DISCOVERED;
	}

}
