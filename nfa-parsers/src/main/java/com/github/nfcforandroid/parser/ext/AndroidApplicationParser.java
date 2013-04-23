package com.github.nfcforandroid.parser.ext;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.exception.ParserException;
import com.github.nfcforandroid.parser.ndef.NdefParser;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;
import com.github.nfcforandroid.records.ndef.ext.AndroidApplicationRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaParser} for a record corresponding to an android.nfc.AndroidApplicationRecord, it will return {@link AndroidApplicationRecord}.
 * 
 *         Don't use it for the moment, it returns null.
 * 
 */
public final class AndroidApplicationParser extends NdefParser {

	protected AndroidApplicationParser() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.ndef.NdefParser#parseNdef(android.nfc.NdefRecord)
	 */
	@Override
	public INfaRecord parseNdef(NdefRecord ndefRecord) {

		byte[] packageNameArray = ndefRecord.getPayload();
		if (packageNameArray.length == 0) {
			throw new ParserException(new IllegalArgumentException("Package name is empty"));
		}
		byte[] typeArray = ndefRecord.getType();
		String type = new String(typeArray);
		if (!AndroidApplicationRecord.TYPE.equals(type)) {
			throw new ParserException(new IllegalArgumentException("Record is not an AndroidApplicationRecord"));

		}

		return NfaRecordFactory.externalFactory().androidApplicationRecordInstance(new String(packageNameArray));
	}

}
