package com.nfa.tools.parser.ndef;

import java.nio.charset.Charset;

import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.exception.ParserException;
import com.nfa.tools.records.factory.NfaRecordFactory;

public class MimeTypeParser extends NdefParser {

	MimeTypeParser() {
	}

	@Override
	public INfaRecord parseNdef(NdefRecord record) throws ParserException {

		String contentType = new String(record.getType(), Charset.forName("US_ASCII"));

		return NfaRecordFactory.ndefFactory().mimeRecordInstance(contentType, record.getPayload());
	}

}
