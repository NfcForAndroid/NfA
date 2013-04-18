package com.nfa.tools.records.ndef;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.records.AbstractRecord;

/**
 * @author jefBinomed {@link INfaRecord} for unkown record
 * 
 *         The class contains a byte of array for the payload of the record
 */
public class UnknownRecord extends AbstractRecord implements INdefRecord {

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
	 * @param payload
	 */
	public void setPayload(byte[] payload) {
		this.payload = payload;
	}

	/**
	 * @return <code>true</code> if the payload is not empty, <code>false</code> else
	 */
	public boolean hasPayload() {
		return payload != null;
	}

}
