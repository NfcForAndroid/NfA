package com.nfa.tools.parser.base;

import android.nfc.Tag;

import com.nfa.tools.api.INfaRecord;

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
	 * @see com.nfa.tools.parser.base.NfaParserAdapter#parseTag(android.nfc.Tag)
	 */
	@Override
	public INfaRecord parseTag(Tag tag) {
		// To implement
		return null;
	}

}
