package com.github.nfcforandroid.filters.ndef.wkt;

import android.nfc.NfcAdapter;

import com.github.nfcforandroid.api.INfaIntentFilter;

/**
 * @author jefBinomed
 * 
 * 
 *         Class that represent a {@link INfaIntentFilter} for Text type
 * 
 *         Action = {@link NfcAdapter#ACTION_NDEF_DISCOVERED}
 * 
 *         DataType = "text/plain"
 * 
 */
public final class TextFilter extends WellKnowFilter {

	protected TextFilter() {
	}

	@Override
	public String getDataType() {
		return "text/plain";
	}

}
