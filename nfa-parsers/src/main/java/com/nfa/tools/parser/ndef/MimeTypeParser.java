package com.nfa.tools.parser.ndef;

import java.nio.charset.Charset;

import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.exception.ParserException;
import com.nfa.tools.records.factory.NfaRecordFactory;
import com.nfa.tools.records.ndef.MimeTypeRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaParser} for Mime type data.
 * 
 *         The return value is a {@link MimeTypeRecord}
 * 
 * 
 */
public class MimeTypeParser extends NdefParser {

	MimeTypeParser() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.ndef.NdefParser#parseNdef(android.nfc.NdefRecord)
	 */
	@Override
	public INfaRecord parseNdef(NdefRecord record) throws ParserException {

		String contentType = new String(record.getType(), Charset.forName("US_ASCII"));

		return NfaRecordFactory.ndefFactory().mimeRecordInstance(contentType, record.getPayload());
	}

}
