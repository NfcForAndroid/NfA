package com.nfa.tools.parser.ndef.wkt;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.exception.ParserException;
import com.nfa.tools.parser.factory.NfaParserFactory;
import com.nfa.tools.parser.ndef.NdefParser;
import com.nfa.tools.records.factory.NfaRecordFactory;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecordDatas;
import com.nfa.tools.records.ndef.wkt.TextRecord;
import com.nfa.tools.records.ndef.wkt.UriRecord;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecordDatas.SmartPosterRecordDatasBuilder;

public final class SmartPosterParser extends NdefParser {

	SmartPosterParser() {
	}

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
