package com.nfa.tools.filters.base;

import android.nfc.NfcAdapter;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.NfaFilterAdapter;

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
	 * @see com.nfa.tools.filters.NfaFilterAdapter#getAction()
	 */
	@Override
	public String getAction() {
		return NfcAdapter.ACTION_TAG_DISCOVERED;
	}

}
