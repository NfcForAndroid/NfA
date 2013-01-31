package com.greennfc.tools.parser.ext;

import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.parser.base.NdefParser;
import com.greennfc.tools.records.factory.GreenRecordFactory;
import com.greennfc.tools.records.ndef.ext.TextExternalRecord;

public final class TextExternalParser extends NdefParser {

	protected TextExternalParser() {
	}

	@Override
	public IGreenRecord parseNdef(NdefRecord ndefRecord) {

		byte[] payload = ndefRecord.getPayload();

		String message = new String(payload);
		TextExternalRecord textRecord = GreenRecordFactory.externalFactory().textExternalRecordInstance(message);
		return textRecord;
	}

}
