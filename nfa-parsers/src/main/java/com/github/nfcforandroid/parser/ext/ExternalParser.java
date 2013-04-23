package com.github.nfcforandroid.parser.ext;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.exception.ParserException;
import com.github.nfcforandroid.parser.ndef.NdefParser;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;
import com.github.nfcforandroid.records.ndef.NdefRecord;
import com.github.nfcforandroid.records.ndef.ext.ExternalRecord;

/**
 * @author jefBinomed
 * 
 *         External type parser, it will return a {@link NdefRecord}
 */
public class ExternalParser extends NdefParser {

	private static final String DOMAIN_SEPARATOR = ":";

	protected ExternalParser() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.ndef.NdefParser#parseNdef(android.nfc.NdefRecord)
	 */
	@Override
	public INfaRecord parseNdef(android.nfc.NdefRecord ndefRecord) {
		byte[] payload = ndefRecord.getPayload();

		ExternalRecord textRecord = NfaRecordFactory.externalFactory().externalRecordInstance(verifyType(ndefRecord), payload);
		return textRecord;
	}

	protected String verifyType(android.nfc.NdefRecord ndefRecord) {
		byte[] typeArray = ndefRecord.getType();
		String type = new String(typeArray);
		if (type.indexOf(DOMAIN_SEPARATOR) == -1) {
			throw new ParserException(new IllegalArgumentException("The external type is malformed"));
		}
		return type;
	}

}
