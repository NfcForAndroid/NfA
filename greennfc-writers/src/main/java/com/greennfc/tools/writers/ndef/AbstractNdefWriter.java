package com.greennfc.tools.writers.ndef;

import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.writers.AbstractWriter;

public abstract class AbstractNdefWriter<Record extends IGreenRecord> extends AbstractWriter<Record> {

	protected NdefRecord ndefRecord;

	public int getLength() {

		short tnf = ndefRecord.getTnf();
		byte[] type = ndefRecord.getType();
		byte[] payload = ndefRecord.getPayload();
		byte[] id = ndefRecord.getId();

		// Tnf
		int lengthTmp = ((Short) tnf).toString().getBytes().length;
		int length = ((Short) tnf).toString().getBytes().length;
		// Type
		lengthTmp = type.length;
		length += lengthTmp;
		// Payload
		lengthTmp = payload.length;
		length += lengthTmp;
		// Id
		lengthTmp = id.length;
		length += lengthTmp;
		return length;
	}

}
