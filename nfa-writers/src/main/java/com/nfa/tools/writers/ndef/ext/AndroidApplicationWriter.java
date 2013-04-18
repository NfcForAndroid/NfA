package com.nfa.tools.writers.ndef.ext;

import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.ext.AndroidApplicationRecord;
import com.nfa.tools.writers.ndef.AbstractNdefWriter;

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
	 * @see com.nfa.tools.api.INfaWriter#getNdefRecord()
	 */
	public NdefRecord getNdefRecord() {

		if (record.getPackageName() == null) {
			throw new IllegalArgumentException("Expected package name");
		}

		short tnf = NdefRecord.TNF_EXTERNAL_TYPE;
		byte[] type = "android.com:pkg".getBytes();
		byte[] payload = record.getPackageName().getBytes();
		NdefRecord record = new NdefRecord(tnf //
				, type //
				, new byte[0] //
				, payload //
		);

		return record;
	}
}
