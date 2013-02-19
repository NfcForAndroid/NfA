package com.greennfc.tools.parser.ndef;import android.nfc.NdefRecord;import com.greennfc.tools.api.IGreenRecord;import com.greennfc.tools.parser.base.GreenParserAdapter;import com.greennfc.tools.records.factory.GreenRecordFactory;;public class UnknownParser extends GreenParserAdapter {	UnknownParser() {	}	@Override	public IGreenRecord parseNdef(NdefRecord ndefRecord) {		byte[] type = ndefRecord.getType();		if (type != null && type.length > 0) {			throw new IllegalArgumentException("Record type not expeted");		}		return GreenRecordFactory.ndefFactory().unknownRecordInstance(ndefRecord.getPayload());	}}