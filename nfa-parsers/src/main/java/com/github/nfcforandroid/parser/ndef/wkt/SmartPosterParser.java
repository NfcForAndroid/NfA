package com.github.nfcforandroid.parser.ndef.wkt;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.exception.ParserException;
import com.github.nfcforandroid.parser.factory.NfaParserFactory;
import com.github.nfcforandroid.parser.ndef.NdefParser;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;
import com.github.nfcforandroid.records.ndef.UnknownRecord;
import com.github.nfcforandroid.records.ndef.wkt.SmartPosterRecordDatas;
import com.github.nfcforandroid.records.ndef.wkt.SmartPosterRecordDatas.SmartPosterRecordDatasBuilder;
import com.github.nfcforandroid.records.ndef.wkt.TextRecord;
import com.github.nfcforandroid.records.ndef.wkt.UriRecord;

/**
 * @author jefBinomed
 * 
 * 
 *         {@link INfaParser} for Unkown data.
 * 
 *         The return value is a {@link UnknownRecord}
 * 
 *         a {@link ParserException} could be thrown if the type is the payload is not an ndef message
 */
public final class SmartPosterParser extends NdefParser {

	SmartPosterParser() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.ndef.NdefParser#parseNdef(android.nfc.NdefRecord)
	 */
	@Override
	public INfaRecord parseNdef(NdefRecord ndefRecord) {

		byte[] payload = ndefRecord.getPayload();

		if (payload.length == 0) {
			return null;
		}
		NdefMessage message;
		try {
			message = new NdefMessage(payload);
		} catch (FormatException e) {
			throw new ParserException(e);
		}
		SmartPosterRecordDatasBuilder smartPosterRecordDatas = SmartPosterRecordDatas.instance();
		INfaRecord record = null;
		for (NdefRecord ndefRecordTmp : message.getRecords()) {
			record = NfaParserFactory.ndefFactory().ndefParser().parseNdef(ndefRecordTmp);
			if (record instanceof UriRecord) {
				smartPosterRecordDatas.uri((UriRecord) record);
			} else if (record instanceof TextRecord) {
				smartPosterRecordDatas.title((TextRecord) record);
			}
			// else if (record instanceof ActionRecord) {
			// smartPosterRecord.setAction((ActionRecord) record);
			// }
			else {
			}
		}
		return NfaRecordFactory.wellKnowTypeFactory().smartPosterRecordInstance(smartPosterRecordDatas.build());
	}
}
