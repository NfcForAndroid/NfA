package com.github.nfcforandroid.records.ndef;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.records.AbstractRecord;

/**
 * @author jefBinomed {@link INfaRecord} for unkown record
 * 
 *         The class contains a byte of array for the payload of the record
 */
public final class UnknownRecord extends AbstractRecord implements INdefRecord {

	private byte[] payload;

	UnknownRecord(byte[] payload) {
		this.payload = payload;
	}

	/**
	 * @return the datas of the record
	 */
	public byte[] getPayload() {
		return payload;
	}

	/**
	 * @return <code>true</code> if the payload is not empty, <code>false</code> else
	 */
	public boolean hasPayload() {
		return payload != null;
	}

}
