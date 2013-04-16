package com.nfa.tools.records;

import java.util.Arrays;

import com.nfa.tools.api.INfaRecord;

public abstract class AbstractRecord implements INfaRecord {

	private byte[] id = new byte[0];

	protected AbstractRecord() {
		super();
	}

	public AbstractRecord(String id) {
		super();
		this.id = id.getBytes();
	}

	public AbstractRecord(byte[] id) {
		super();
		this.id = id;
	}

	public byte[] getId() {
		return id;
	}

	public void setId(byte[] id) {
		this.id = id;
	}

	public String getKey() {
		// TODO manage id == null
		return new String(id);
	}

	public void setKey(String id) {
		// TODO manage id == null
		this.id = id.getBytes();
	}

	public boolean hasId() {
		return id != null && id.length > 0;
	}

	public boolean hasKey() {
		return hasId();
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
		AbstractRecord other = (AbstractRecord) obj;
		if (!Arrays.equals(id, other.id))
			return false;
		return true;
	}

}
