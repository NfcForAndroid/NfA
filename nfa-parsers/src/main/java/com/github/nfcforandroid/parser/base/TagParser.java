package com.github.nfcforandroid.parser.base;

import android.nfc.Tag;

import com.github.nfcforandroid.api.INfaRecord;

/**
 * @author jefBinomed
 * 
 *         {@link Tag} parser. For the moment, return <code>null</code>. Don't use it
 * 
 */
class TagParser extends NfaParserAdapter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.base.NfaParserAdapter#parseTag(android.nfc.Tag)
	 */
	@Override
	public INfaRecord parseTag(Tag tag) {
		// To implement
		return null;
	}

}
