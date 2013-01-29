package com.greennfc.tools.parser.base;

import android.nfc.NdefRecord;
import android.nfc.Tag;

import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.api.IGreenRecord;

abstract class GreenParserAdapter implements IGreenParser {

	public IGreenRecord parseNdef(NdefRecord record) {
		// Nothing to do, have to be override
		return null;
	}

	public IGreenRecord parseTag(Tag tag) {
		// Nothing to do, have to be override
		return null;
	}

}
