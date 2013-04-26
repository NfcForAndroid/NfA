package com.github.nfcforandroid.filters.base;

import android.nfc.NfcAdapter;

import com.github.nfcforandroid.api.INfaIntentFilter;
import com.github.nfcforandroid.filters.NfaFilterAdapter;

/**
 * @author jefBinomed
 * 
 *         Class that represent a {@link INfaIntentFilter} for Tag
 * 
 *         Action = {@link NfcAdapter#ACTION_TAG_DISCOVERED}
 * 
 */
public class TagFilter extends NfaFilterAdapter {

	protected TagFilter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.filters.NfaFilterAdapter#getAction()
	 */
	@Override
	public String getAction() {
		return NfcAdapter.ACTION_TAG_DISCOVERED;
	}

}
