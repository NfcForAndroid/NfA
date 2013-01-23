package com.greennfc.tools.records.ndef;

import java.util.Arrays;

import com.greennfc.tools.api.IGreenRecord;

public class NdefRecord implements IGreenRecord {

	protected byte[] id = new byte[0];

	private android.nfc.NdefRecord androidNdefRecord;

	public NdefRecord() {
		super();
	}

	public NdefRecord(String key) {
		super();
		this.id = key.getBytes();
	}

	public NdefRecord(android.nfc.NdefRecord androidNdefRecord) {
		super();
		this.androidNdefRecord = androidNdefRecord;
		if (this.androidNdefRecord.getId() != null && this.androidNdefRecord.getId().length > 0) {
			id = this.androidNdefRecord.getId();
		}
	}

	public byte[] getId() {
		return id;
	}

	public void setId(byte[] id) {
		this.id = id;
	}

	public String getKey() {
		return new String(id);
	}

	public void setKey(String key) {
		this.id = key.getBytes();
	}

	public boolean hasKey() {
		return id != null && id.length > 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NdefRecord other = (NdefRecord) obj;
		if (!Arrays.equals(id, other.id))
			return false;
		return true;
	}

}
