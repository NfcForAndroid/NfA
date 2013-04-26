package com.github.nfcforandroid.parser.ndef;

import java.nio.charset.Charset;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.exception.ParserException;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;
import com.github.nfcforandroid.records.ndef.MimeTypeRecord;

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
	 * @see com.github.nfcforandroid.parser.ndef.NdefParser#parseNdef(android.nfc.NdefRecord)
	 */
	@Override
	public INfaRecord parseNdef(NdefRecord record) throws ParserException {

		String contentType = new String(record.getType(), Charset.forName("US_ASCII"));

		return NfaRecordFactory.ndefRecords().mimeRecordInstance(contentType, record.getPayload());
	}

}
