package com.greennfc.tools.filters;

import android.nfc.NfcAdapter;

public class TagFilter extends GreenFilterAdapter {

	@Override
	public String getAction() {
		return NfcAdapter.ACTION_TAG_DISCOVERED;
	}

}
