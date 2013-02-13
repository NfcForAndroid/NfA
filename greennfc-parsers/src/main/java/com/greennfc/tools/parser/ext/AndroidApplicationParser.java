package com.greennfc.tools.parser.ext;

import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.parser.ndef.NdefParser;

public final class AndroidApplicationParser extends NdefParser {

	protected AndroidApplicationParser() {
	}

	@Override
	public IGreenRecord parseNdef(NdefRecord ndefRecord) {

		return null;
	}

}
