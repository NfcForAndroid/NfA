package com.github.nfcforandroid.parser.ndef.wkt;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.parser.ndef.NdefParser;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;
import com.github.nfcforandroid.records.ndef.wkt.TextRecord;

/**
 * @author jefBinomed
 * 
 * 
 *         {@link INfaParser} for Text data.
 * 
 *         The return value is a {@link TextRecord}
 * 
 */
public final class TextParser extends NdefParser {

	protected TextParser() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.ndef.NdefParser#parseNdef(android.nfc.NdefRecord)
	 */
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
		TextRecord textRecord = NfaRecordFactory.wellKnowTypeRecords().textRecordInstance(message, textEncoding, new Locale(languageCode));
		return textRecord;
	}

}
