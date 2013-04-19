package com.github.nfcforandroid.records;

import java.util.Arrays;

import com.github.nfcforandroid.api.INfaRecord;

/**
 * @author jefBinomed
 * 
 *         Abstract record that only contains a byte array for the id of the tags
 */
public abstract class AbstractRecord implements INfaRecord {

	private byte[] id = new byte[0];

	protected AbstractRecord() {
		super();
	}

	/**
	 * @param id
	 */
	protected AbstractRecord(String id) {
		super();
		this.id = id.getBytes();
	}

	/**
	 * @param id
	 */
	protected AbstractRecord(byte[] id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id of the tag
	 */
	public byte[] getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(byte[] id) {
		this.id = id;
	}

	/**
	 * @return the string representation of the id
	 */
	public String getKey() {
		// TODO manage id == null
		return new String(id);
	}

	/**
	 * @param id
	 *            the string representation of the id
	 */
	public void setKey(String id) {
		// TODO manage id == null
		this.id = id.getBytes();
	}

	/**
	 * @return <code>true</code> if the id array is not empty, <code>false</code> else
	 */
	public boolean hasId() {
		return id != null && id.length > 0;
	}

	/**
	 * @return just call {@link #hasId()}
	 */
	public boolean hasKey() {
		return hasId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
