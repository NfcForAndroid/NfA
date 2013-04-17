package com.nfa.tools.filters.ndef.ext;

import android.nfc.NfcAdapter;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.base.NdefFilter;
import com.nfa.tools.filters.cst.NfaFiltersCst;

/**
 * @author jefBinomed
 * 
 *         Class that represent a {@link INfaIntentFilter} for External type
 * 
 *         Action = {@link NfcAdapter#ACTION_NDEF_DISCOVERED}
 * 
 *         AuthorityHost = {@link NfaFiltersCst#AUTHORITY_NDEF}
 * 
 *         DataScheme = {@link NfaFiltersCst#SCHEME_NDEF}
 * 
 *         DataPath = the {@link #path}
 */
public final class TextExternalNdefFilter extends NdefFilter {

	private final String path;

	protected TextExternalNdefFilter(String path) {
		this.path = path;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.filters.NfaFilterAdapter#getDataAuthorityHost()
	 */
	@Override
	public String getDataAuthorityHost() {
		return NfaFiltersCst.AUTHORITY_NDEF;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.filters.NfaFilterAdapter#getDataScheme()
	 */
	@Override
	public String getDataScheme() {
		return NfaFiltersCst.SCHEME_NDEF;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.filters.NfaFilterAdapter#getDataPath()
	 */
	@Override
	public String getDataPath() {
		return path;
	}

}
