package com.nfa.tools.filters.base;

import android.nfc.NfcAdapter;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.NfaFilterAdapter;

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
	 * @see com.nfa.tools.filters.NfaFilterAdapter#getAction()
	 */
	@Override
	public String getAction() {
		return NfcAdapter.ACTION_NDEF_DISCOVERED;
	}

}
