package com.nfa.tools.writers.ndef;

import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaWriter;

/**
 * @author jefBinomed
 * 
 * 
 *         {@link INfaWriter} for Ndef data.
 * 
 *         An {@link IllegalArgumentException} is thrown if the {@link NdefRecord} is not present
 */
public class NdefWriter extends AbstractNdefWriter<com.nfa.tools.records.ndef.NdefRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaWriter#getNdefRecord()
	 */
	public NdefRecord getNdefRecord() {

		if (record.getAndroidNdefRecord() == null) {
			throw new IllegalArgumentException("Expected Ndef record content");
		}

		return record.getAndroidNdefRecord();
	}
}
