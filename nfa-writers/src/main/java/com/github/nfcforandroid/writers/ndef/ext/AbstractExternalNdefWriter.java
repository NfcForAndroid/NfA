package com.github.nfcforandroid.writers.ndef.ext;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.ext.ExternalRecord;
import com.github.nfcforandroid.writers.ndef.AbstractNdefWriter;

/**
 * @author jefBinomed
 * 
 *         Abstract {@link INfaWriter} for external type.
 * 
 *         An {@link IllegalArgumentException} is thrown if no type is defined
 */
abstract class AbstractExternalNdefWriter<T extends ExternalRecord> extends AbstractNdefWriter<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaWriter#getNdefRecord()
	 */
	public NdefRecord getNdefRecord() {

		if (record.getType() == null) {
			throw new IllegalArgumentException("Expected type");
		}

		short tnf = NdefRecord.TNF_EXTERNAL_TYPE;
		byte[] type = record.getTypeArray();
		byte[] payload = record.getDatas();
		NdefRecord record = new NdefRecord(tnf //
				, type //
				, new byte[0] //
				, payload //
		);

		return record;
	}
}
