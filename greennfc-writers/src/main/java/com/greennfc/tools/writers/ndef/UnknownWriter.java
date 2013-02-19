package com.greennfc.tools.writers.ndef;

import android.nfc.NdefRecord;

import com.greennfc.tools.records.ndef.UnknownRecord;

public class UnknownWriter extends AbstractNdefWriter<UnknownRecord> {

	public NdefRecord getNdefRecord() {

		return new NdefRecord(NdefRecord.TNF_UNKNOWN //
				, EMPTY_BYTE //
				, record.getId() != null ? record.getId() : EMPTY_BYTE //
				, record.getPayload() != null ? record.getPayload() : EMPTY_BYTE //
		);
	}
}
