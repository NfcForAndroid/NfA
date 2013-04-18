package com.nfa.tools.parser.ext;

import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.parser.ndef.NdefParser;
import com.nfa.tools.records.ndef.ext.AndroidApplicationRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaParser} for a record corresponding to an android.nfc.AndroidApplicationRecord, it will return {@link AndroidApplicationRecord}.
 * 
 *         Don't use it for the moment, it returns null.
 * 
 */
public final class AndroidApplicationParser extends NdefParser {

	protected AndroidApplicationParser() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.ndef.NdefParser#parseNdef(android.nfc.NdefRecord)
	 */
	@Override
	public INfaRecord parseNdef(NdefRecord ndefRecord) {
		// TODO to implement, when done, change javadoc
		return null;
	}

}
