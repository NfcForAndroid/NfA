package com.greennfc.tools.filters;

import android.nfc.NfcAdapter;

import com.greennfc.tools.api.IGreenIntentFilter;

public class TagFilter implements IGreenIntentFilter {

	public String getType() {
		return null;
	}

	public String getAction() {
		return NfcAdapter.ACTION_TAG_DISCOVERED;
	}

}
