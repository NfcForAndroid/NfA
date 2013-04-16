package com.nfa.tools.parser.ndef.wkt;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.parser.ndef.NdefParser;
import com.nfa.tools.records.factory.NfaRecordFactory;
import com.nfa.tools.records.ndef.wkt.TextRecord;

public final class TextParser extends NdefParser {

	protected TextParser() {
	}

	@Override
	public INfaRecord parseNdef(NdefRecord ndefRecord) {

		byte[] payload = ndefRecord.getPayload();

		ByteArrayInputStream bais = new ByteArrayInputStream(payload);

		int status = bais.read();
		byte languageCodeLength = (byte) (status & TextRecord.LANGUAGE_CODE_MASK);
		byte[] bytes = new byte[languageCodeLength];
		bais.read(bytes, 0, bytes.length);
		String languageCode = new String(bytes);

		bytes = new byte[payload.length - languageCodeLength - 1];
		bais.read(bytes, 0, bytes.length);
		byte[] textData = bytes;
		Charset textEncoding = ((status & 0x80) != 0) ? TextRecord.UTF16 : TextRecord.UTF8;
		String message = null;
		try {
			message = new String(textData, textEncoding.name());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		TextRecord textRecord = NfaRecordFactory.wellKnowTypeFactory().textRecordInstance(message, textEncoding, new Locale(languageCode));
		return textRecord;
	}

}
