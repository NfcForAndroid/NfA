package com.nfa.tools.records.ndef;

import com.nfa.tools.records.AbstractRecord;

public class UnknownRecord extends AbstractRecord implements INdefRecord {

	private byte[] payload;

	UnknownRecord(byte[] payload) {
		this.payload = payload;
	}

	public byte[] getPayload() {
		return payload;
	}

	public void setPayload(byte[] payload) {
		this.payload = payload;
	}

	public boolean hasPayload() {
		return payload != null;
	}

}
