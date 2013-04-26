package com.github.nfcforandroid.parser.base;

import android.nfc.NdefRecord;
import android.nfc.Tag;

import com.github.nfcforandroid.api.INfaIntentFilter;
import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.api.INfaRecord;

/**
 * @author jefBinomed
 * 
 *         Abstract adapter that is use to implement {@link INfaParser}.
 * 
 *         The two methods returns <code>null</code>
 */
public abstract class NfaParserAdapter implements INfaParser {

	protected INfaIntentFilter[] filters = new INfaIntentFilter[] {};

	public void setFilters(INfaIntentFilter... filters) {
		if (filters != null) {
			this.filters = filters;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaParser#parseNdef(android.nfc.NdefRecord)
	 */
	public INfaRecord parseNdef(NdefRecord record) {
		// Nothing to do, have to be override
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaParser#parseTag(android.nfc.Tag)
	 */
	public INfaRecord parseTag(Tag tag) {
		// Nothing to do, have to be override
		return null;
	}

}
