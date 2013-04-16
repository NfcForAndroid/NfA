package com.nfa.tools.parser.ext;

import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.parser.ndef.NdefParser;

public final class AndroidApplicationParser extends NdefParser {

	protected AndroidApplicationParser() {
	}

	@Override
	public INfaRecord parseNdef(NdefRecord ndefRecord) {

		return null;
	}

}
