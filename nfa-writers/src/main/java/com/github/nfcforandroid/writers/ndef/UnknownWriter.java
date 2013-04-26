package com.github.nfcforandroid.writers.ndef;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.UnknownRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaWriter} for Unknown data.
 * 
 */
public class UnknownWriter extends AbstractNdefWriter<UnknownRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaWriter#getNdefRecord()
	 */
	public NdefRecord getNdefRecord() {

		return new NdefRecord(NdefRecord.TNF_UNKNOWN //
				, EMPTY_BYTE //
				, record.getId() != null ? record.getId() : EMPTY_BYTE //
				, record.getPayload() != null ? record.getPayload() : EMPTY_BYTE //
		);
	}
}
