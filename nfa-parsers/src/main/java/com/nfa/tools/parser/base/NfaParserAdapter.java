package com.nfa.tools.parser.base;

import android.nfc.NdefRecord;
import android.nfc.Tag;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.api.INfaRecord;

/**
 * @author jefBinomed
 * 
 *         Abstract adapter that is use to implement {@link INfaParser}.
 * 
 *         The two methods returns <code>null</code>
 */
public abstract class NfaParserAdapter implements INfaParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaParser#parseNdef(android.nfc.NdefRecord)
	 */
	public INfaRecord parseNdef(NdefRecord record) {
		// Nothing to do, have to be override
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaParser#parseTag(android.nfc.Tag)
	 */
	public INfaRecord parseTag(Tag tag) {
		// Nothing to do, have to be override
		return null;
	}

}
