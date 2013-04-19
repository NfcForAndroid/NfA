package com.github.nfcforandroid.writers.ndef;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.UnsupportedRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaWriter} for unsupported data.
 * 
 */
public class UnsupportedWriter extends AbstractNdefWriter<UnsupportedRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaWriter#getNdefRecord()
	 */
	public NdefRecord getNdefRecord() {

		return new NdefRecord(record.getTnf() //
				, record.getType() != null ? record.getType() : EMPTY_BYTE //
				, record.getId() != null ? record.getId() : EMPTY_BYTE //
				, record.getPayload() != null ? record.getPayload() : EMPTY_BYTE //
		);
	}
}
