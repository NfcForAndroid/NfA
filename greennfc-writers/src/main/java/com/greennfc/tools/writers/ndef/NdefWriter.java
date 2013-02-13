package com.greennfc.tools.writers.ndef;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.greennfc.tools.writers.AbstractWriter;

public class NdefWriter<Record extends com.greennfc.tools.records.ndef.NdefRecord> extends AbstractWriter<Record> {

	public NdefMessage getNdefMessage() {
		NdefRecord ndefRecord = getNdefRecord();
		NdefRecord[] records = new NdefRecord[] { ndefRecord };
		NdefMessage msg = new NdefMessage(records);
		return msg;
	}

	public int getLength() {
		NdefRecord ndefRecord = getNdefRecord();

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

	public NdefRecord getNdefRecord() {

		if (record.getAndroidNdefRecord() == null) {
			throw new IllegalArgumentException("Expected Ndef record content");
		}

		return record.getAndroidNdefRecord();
	}
}
