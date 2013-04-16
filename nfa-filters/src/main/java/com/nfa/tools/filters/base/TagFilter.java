package com.nfa.tools.filters.base;

import android.nfc.NfcAdapter;

import com.nfa.tools.filters.NfaFilterAdapter;

public class TagFilter extends NfaFilterAdapter {

	protected TagFilter() {
	}

	@Override
	public String getAction() {
		return NfcAdapter.ACTION_TAG_DISCOVERED;
	}

}
