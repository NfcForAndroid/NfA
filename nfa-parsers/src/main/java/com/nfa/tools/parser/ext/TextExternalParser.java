package com.nfa.tools.parser.ext;

import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.parser.ndef.NdefParser;
import com.nfa.tools.records.factory.NfaRecordFactory;
import com.nfa.tools.records.ndef.ext.TextExternalRecord;

public final class TextExternalParser extends NdefParser {

	protected TextExternalParser() {
	}

	@Override
	public INfaRecord parseNdef(NdefRecord ndefRecord) {

		byte[] payload = ndefRecord.getPayload();

		String message = new String(payload);
		TextExternalRecord textRecord = NfaRecordFactory.externalFactory().textExternalRecordInstance(message);
		return textRecord;
	}

}
