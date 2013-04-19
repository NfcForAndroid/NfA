package com.github.nfcforandroid.filters.base;

import android.nfc.NfcAdapter;

import com.github.nfcforandroid.api.INfaIntentFilter;
import com.github.nfcforandroid.filters.NfaFilterAdapter;

/**
 * @author jefBinomed
 * 
 *         Class that represent a {@link INfaIntentFilter} for Tech
 * 
 *         Action = {@link NfcAdapter#ACTION_TECH_DISCOVERED}
 */
public class TechFilter extends NfaFilterAdapter {

	protected TechFilter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.filters.NfaFilterAdapter#getAction()
	 */
	@Override
	public String getAction() {
		return NfcAdapter.ACTION_TECH_DISCOVERED;
	}

}
