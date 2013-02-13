package com.greennfc.tools.parser.ndef;

import java.nio.charset.Charset;

import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.exception.ParserException;
import com.greennfc.tools.records.factory.GreenRecordFactory;

public class MimeTypeParser extends NdefParser {

	@Override
	public IGreenRecord parseNdef(NdefRecord record) throws ParserException {

		String contentType = new String(record.getType(), Charset.forName("US_ASCIII"));

		return GreenRecordFactory.ndefFactory().mimeRecordInstance(contentType, record.getPayload());
	}

}
