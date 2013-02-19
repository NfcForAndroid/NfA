package com.greennfc.tools.parser.ndef.wkt;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.exception.ParserException;
import com.greennfc.tools.parser.factory.GreenParserFactory;
import com.greennfc.tools.parser.ndef.NdefParser;
import com.greennfc.tools.records.factory.GreenRecordFactory;
import com.greennfc.tools.records.ndef.wkt.SmartPosterRecordDatas;
import com.greennfc.tools.records.ndef.wkt.SmartPosterRecordDatas.SmartPosterRecordDatasBuilder;
import com.greennfc.tools.records.ndef.wkt.TextRecord;
import com.greennfc.tools.records.ndef.wkt.UriRecord;

public final class SmartPosterParser extends NdefParser {

	SmartPosterParser() {
	}

	@Override
	public IGreenRecord parseNdef(NdefRecord ndefRecord) {

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
		IGreenRecord record = null;
		for (NdefRecord ndefRecordTmp : message.getRecords()) {
			record = GreenParserFactory.ndefFactory().ndefParser().parseNdef(ndefRecordTmp);
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
		return GreenRecordFactory.wellKnowTypeFactory().smartPosterRecordInstance(smartPosterRecordDatas.build());
	}
}
