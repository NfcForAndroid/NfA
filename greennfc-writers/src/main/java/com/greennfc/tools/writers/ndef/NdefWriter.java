package com.greennfc.tools.writers.ndef;

import android.nfc.NdefRecord;

public class NdefWriter extends AbstractNdefWriter<com.greennfc.tools.records.ndef.NdefRecord> {

	public NdefRecord getNdefRecord() {

		if (record.getAndroidNdefRecord() == null) {
			throw new IllegalArgumentException("Expected Ndef record content");
		}

		return record.getAndroidNdefRecord();
	}
}
