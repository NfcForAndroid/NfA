package com.github.nfcforandroid.filters.base;

import android.nfc.NfcAdapter;

import com.github.nfcforandroid.api.INfaIntentFilter;
import com.github.nfcforandroid.filters.NfaFilterAdapter;

/**
 * @author jefBinomed
 * 
 * 
 *         Class that represent a {@link INfaIntentFilter} for Ndef
 * 
 *         Action = {@link NfcAdapter#ACTION_NDEF_DISCOVERED}
 */
public class NdefFilter extends NfaFilterAdapter {

	protected NdefFilter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.filters.NfaFilterAdapter#getAction()
	 */
	@Override
	public String getAction() {
		return NfcAdapter.ACTION_NDEF_DISCOVERED;
	}

}
