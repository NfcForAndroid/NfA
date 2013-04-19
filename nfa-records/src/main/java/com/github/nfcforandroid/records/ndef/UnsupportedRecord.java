package com.github.nfcforandroid.records.ndef;

import com.github.nfcforandroid.api.INfaRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaRecord} for unsupported data.
 */
public class UnsupportedRecord extends NdefRecord {

	UnsupportedRecord(android.nfc.NdefRecord androidNdefRecord) {
		super(androidNdefRecord);
	}

	UnsupportedRecord(short tnf, byte[] id, byte[] type, byte[] payload) {
		super(tnf, id, type, payload);
	}

}
