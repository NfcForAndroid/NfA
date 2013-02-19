package com.greennfc.tools.records.ndef;

public class UnsupportedRecord extends NdefRecord {

	UnsupportedRecord(android.nfc.NdefRecord androidNdefRecord) {
		super(androidNdefRecord);
	}

	UnsupportedRecord(short tnf, byte[] id, byte[] type, byte[] payload) {
		super(tnf, id, type, payload);
	}

}
