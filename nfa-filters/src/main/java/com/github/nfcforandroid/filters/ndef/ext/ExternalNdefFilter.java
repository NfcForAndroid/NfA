package com.github.nfcforandroid.filters.ndef.ext;

import android.nfc.NfcAdapter;

import com.github.nfcforandroid.api.INfaIntentFilter;
import com.github.nfcforandroid.filters.base.NdefFilter;
import com.github.nfcforandroid.filters.cst.NfaFiltersCst;

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
 * 
 */
public final class ExternalNdefFilter extends NdefFilter {

	/**
	 * the base path
	 */
	private final String path;

	protected ExternalNdefFilter(String path) {
		this.path = path;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.filters.NfaFilterAdapter#getDataAuthorityHost()
	 */
	@Override
	public String getDataAuthorityHost() {
		return NfaFiltersCst.AUTHORITY_NDEF;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.filters.NfaFilterAdapter#getDataScheme()
	 */
	@Override
	public String getDataScheme() {
		return NfaFiltersCst.SCHEME_NDEF;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.filters.NfaFilterAdapter#getDataPath()
	 */
	@Override
	public String getDataPath() {
		return path;
	}

}
