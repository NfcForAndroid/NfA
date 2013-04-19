package com.github.nfcforandroid.writers.ndef;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaWriter;

/**
 * @author jefBinomed
 * 
 * 
 *         {@link INfaWriter} for Ndef data.
 * 
 *         An {@link IllegalArgumentException} is thrown if the {@link NdefRecord} is not present
 */
public class NdefWriter extends AbstractNdefWriter<com.github.nfcforandroid.records.ndef.NdefRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaWriter#getNdefRecord()
	 */
	public NdefRecord getNdefRecord() {

		if (record.getAndroidNdefRecord() == null) {
			throw new IllegalArgumentException("Expected Ndef record content");
		}

		return record.getAndroidNdefRecord();
	}
}
