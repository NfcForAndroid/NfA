package com.greennfc.tools.parser.wkt;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.parser.NdefParser;
import com.greennfc.tools.records.ndef.wkt.TextRecord;

public final class TextParser extends NdefParser {

	protected TextParser() {
	}

	@Override
	public IGreenRecord parseNdef(NdefRecord ndefRecord) {

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
		TextRecord textRecord = new TextRecord(message, textEncoding, new Locale(languageCode));
		return textRecord;
	}

}
