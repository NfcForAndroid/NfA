package com.github.nfcforandroid.parser.ext;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;
import com.github.nfcforandroid.records.ndef.ext.TextExternalRecord;
import com.github.nfcforandroid.records.ndef.wkt.TextRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaParser} for Text External datas.
 * 
 *         The return value is a {@link TextExternalRecord}
 */
public final class TextExternalParser extends ExternalParser {

	protected TextExternalParser() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.ndef.NdefParser#parseNdef(android.nfc.NdefRecord)
	 */
	@Override
	public INfaRecord parseNdef(NdefRecord ndefRecord) {
		byte[] payload = ndefRecord.getPayload();

		Charset textEncoding = TextRecord.UTF8;
		String message = null;
		try {
			message = new String(payload, textEncoding.name());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}

		TextExternalRecord textRecord = NfaRecordFactory.externalFactory().textExternalRecordInstance(verifyType(ndefRecord), message);
		return textRecord;
	}

}
