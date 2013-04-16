package com.nfa.tools.records.ndef;

import com.nfa.tools.records.AbstractRecord;

public class NdefRecord extends AbstractRecord implements INdefRecord {

	private android.nfc.NdefRecord androidNdefRecord;

	protected NdefRecord() {
		super();
	}

	NdefRecord(String key) {
		super();
	}

	NdefRecord(short tnf, byte[] id, byte[] type, byte[] payload) {
		androidNdefRecord = new android.nfc.NdefRecord(tnf, type, id, payload);
		setId(id);
	}

	NdefRecord(android.nfc.NdefRecord androidNdefRecord) {
		super();
		this.androidNdefRecord = androidNdefRecord;
		if (this.androidNdefRecord.getId() != null && this.androidNdefRecord.getId().length > 0) {
			setId(this.androidNdefRecord.getId());
		}
	}

	public short getTnf() {
		return this.androidNdefRecord.getTnf();
	}

	public byte[] getType() {
		return this.androidNdefRecord.getType();
	}

	public byte[] getPayload() {
		return this.androidNdefRecord.getPayload();
	}

	public android.nfc.NdefRecord getAndroidNdefRecord() {
		return androidNdefRecord;
	}

	public void setAndroidNdefRecord(android.nfc.NdefRecord androidNdefRecord) {
		this.androidNdefRecord = androidNdefRecord;
	}

}
