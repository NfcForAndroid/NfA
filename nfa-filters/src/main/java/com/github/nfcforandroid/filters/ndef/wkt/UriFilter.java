package com.github.nfcforandroid.filters.ndef.wkt;

import android.nfc.NfcAdapter;

import com.github.nfcforandroid.api.INfaIntentFilter;

/**
 * @author jefBinomed Class that represent a {@link INfaIntentFilter} for uri filter
 * 
 *         Action = {@link NfcAdapter#ACTION_NDEF_DISCOVERED}
 * 
 *         DataScheme = http
 */
public final class UriFilter extends WellKnowFilter {

	protected UriFilter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.filters.NfaFilterAdapter#getDataScheme()
	 */
	@Override
	public String getDataScheme() {
		return "http";
	}

}
