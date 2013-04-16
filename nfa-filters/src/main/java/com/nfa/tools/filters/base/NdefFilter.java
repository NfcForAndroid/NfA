package com.nfa.tools.filters.base;

import android.nfc.NfcAdapter;

import com.nfa.tools.filters.NfaFilterAdapter;

public class NdefFilter extends NfaFilterAdapter {

	protected NdefFilter() {
	}

	@Override
	public String getAction() {
		return NfcAdapter.ACTION_NDEF_DISCOVERED;
	}

}
