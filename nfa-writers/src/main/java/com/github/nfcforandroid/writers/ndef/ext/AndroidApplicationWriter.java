package com.github.nfcforandroid.writers.ndef.ext;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.ext.AndroidApplicationRecord;
import com.github.nfcforandroid.writers.ndef.AbstractNdefWriter;

/**
 * @author jefBinomed
 * 
 *         {@link INfaWriter} for android application data.
 * 
 *         An {@link IllegalArgumentException} is thrown if the packagename is empty
 */
public class AndroidApplicationWriter extends AbstractNdefWriter<AndroidApplicationRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaWriter#getNdefRecord()
	 */
	public NdefRecord getNdefRecord() {

		if (record.getPackageName() == null) {
			throw new IllegalArgumentException("Expected package name");
		}

		short tnf = NdefRecord.TNF_EXTERNAL_TYPE;
		byte[] type = AndroidApplicationRecord.TYPE.getBytes();
		byte[] payload = record.getPackageName().getBytes();
		NdefRecord record = new NdefRecord(tnf //
				, type //
				, new byte[0] //
				, payload //
		);

		return record;
	}
}
