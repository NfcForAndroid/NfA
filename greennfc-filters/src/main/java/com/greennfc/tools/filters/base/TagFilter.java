package com.greennfc.tools.filters.base;

import android.nfc.NfcAdapter;

import com.greennfc.tools.filters.GreenFilterAdapter;

public class TagFilter extends GreenFilterAdapter {

	protected TagFilter() {
	}

	@Override
	public String getAction() {
		return NfcAdapter.ACTION_TAG_DISCOVERED;
	}

}
