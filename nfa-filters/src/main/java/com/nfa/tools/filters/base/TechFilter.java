package com.nfa.tools.filters.base;

import android.nfc.NfcAdapter;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.NfaFilterAdapter;

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
	 * @see com.nfa.tools.filters.NfaFilterAdapter#getAction()
	 */
	@Override
	public String getAction() {
		return NfcAdapter.ACTION_TECH_DISCOVERED;
	}

}
