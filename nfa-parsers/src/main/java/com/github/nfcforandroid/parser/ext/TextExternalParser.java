package com.github.nfcforandroid.parser.ext;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.parser.ndef.NdefParser;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;
import com.github.nfcforandroid.records.ndef.ext.TextExternalRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaParser} for Text External datas.
 * 
 *         The return value is a {@link TextExternalRecord}
 */
public final class TextExternalParser extends NdefParser {

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

		String message = new String(payload);
		TextExternalRecord textRecord = NfaRecordFactory.externalFactory().textExternalRecordInstance(message);
		return textRecord;
	}

}
