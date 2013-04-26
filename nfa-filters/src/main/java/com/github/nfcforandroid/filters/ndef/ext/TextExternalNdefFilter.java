package com.github.nfcforandroid.filters.ndef.ext;

import android.nfc.NfcAdapter;

import com.github.nfcforandroid.api.INfaIntentFilter;
import com.github.nfcforandroid.filters.cst.NfaFiltersCst;

/**
 * @author jefBinomed
 * 
 *         Class that represent a {@link INfaIntentFilter} for External Text type
 * 
 *         Action = {@link NfcAdapter#ACTION_NDEF_DISCOVERED}
 * 
 *         AuthorityHost = {@link NfaFiltersCst#AUTHORITY_NDEF}
 * 
 *         DataScheme = {@link NfaFiltersCst#SCHEME_NDEF}
 * 
 *         DataPath = the {@link #path}
 */
public final class TextExternalNdefFilter extends ExternalNdefFilter {

	protected TextExternalNdefFilter(String path) {
		super(path);
	}

}
