package com.nfa.tools.writers.ndef;

import android.nfc.NdefRecord;

public class NdefWriter extends AbstractNdefWriter<com.nfa.tools.records.ndef.NdefRecord> {

	public NdefRecord getNdefRecord() {

		if (record.getAndroidNdefRecord() == null) {
			throw new IllegalArgumentException("Expected Ndef record content");
		}

		return record.getAndroidNdefRecord();
	}
}
