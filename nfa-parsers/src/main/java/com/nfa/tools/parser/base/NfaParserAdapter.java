package com.nfa.tools.parser.base;

import android.nfc.NdefRecord;
import android.nfc.Tag;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.api.INfaRecord;

public abstract class NfaParserAdapter implements INfaParser {

	public INfaRecord parseNdef(NdefRecord record) {
		// Nothing to do, have to be override
		return null;
	}

	public INfaRecord parseTag(Tag tag) {
		// Nothing to do, have to be override
		return null;
	}

}
