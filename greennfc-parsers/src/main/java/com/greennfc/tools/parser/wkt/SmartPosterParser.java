package com.greennfc.tools.parser.wkt;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.exception.ParserException;
import com.greennfc.tools.parser.base.NdefParser;
import com.greennfc.tools.parser.factory.GreenParserFactory;
import com.greennfc.tools.records.factory.GreenRecordFactory;
import com.greennfc.tools.records.ndef.wkt.TextRecord;
import com.greennfc.tools.records.ndef.wkt.UriRecord;

public final class SmartPosterParser extends NdefParser {

	protected SmartPosterParser() {
	}

	@Override
	public IGreenRecord parseNdef(NdefRecord ndefRecord) {

		byte[] payload = ndefRecord.getPayload();

		TextRecord title = null;
		UriRecord uri = null;

		if (payload.length == 0) {
			return null;
		}
		NdefMessage message;
		try {
			message = new NdefMessage(payload);
		} catch (FormatException e) {
			throw new ParserException(e);
		}
		IGreenRecord record = null;
		for (NdefRecord ndefRecordTmp : message.getRecords()) {
			record = GreenParserFactory.baseFactory().ndefParser().parseNdef(ndefRecordTmp);
			if (record instanceof UriRecord) {
				uri = (UriRecord) record;
			} else if (record instanceof TextRecord) {
				title = (TextRecord) record;
			}
			// else if (record instanceof ActionRecord) {
			// smartPosterRecord.setAction((ActionRecord) record);
			// }
			else {
			}
		}
		return GreenRecordFactory.wellKnowTypeFactory().smartPosterRecordInstance(title, uri);
	}

}
