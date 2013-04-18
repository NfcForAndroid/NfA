package com.nfa.tools.records.ndef;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.records.AbstractRecord;

/**
 * @author jefBinomed {@link INfaRecord} for ndef data.
 * 
 *         this class contains an An {@link android.nfc.NdefRecord} record
 */
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

	/**
	 * @return the kind of the message
	 */
	public short getTnf() {
		return this.androidNdefRecord.getTnf();
	}

	/**
	 * @return the type of the message
	 */
	public byte[] getType() {
		return this.androidNdefRecord.getType();
	}

	/**
	 * @return the payload of the message
	 */
	public byte[] getPayload() {
		return this.androidNdefRecord.getPayload();
	}

	/**
	 * @return the {@link android.nfc.NdefRecord} record
	 */
	public android.nfc.NdefRecord getAndroidNdefRecord() {
		return androidNdefRecord;
	}

	/**
	 * @param androidNdefRecord
	 */
	public void setAndroidNdefRecord(android.nfc.NdefRecord androidNdefRecord) {
		this.androidNdefRecord = androidNdefRecord;
	}

}
