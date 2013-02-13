package com.greennfc.tools.records.ndef;

import java.util.Arrays;

public class MimeTypeRecord extends NdefRecord {

	private String mimeType;
	private byte[] data;

	public String getMimeType() {
		return mimeType;
	}

	public byte[] getData() {
		return data;
	}

	protected MimeTypeRecord(String mimeType, byte[] data) {
		super();
		this.mimeType = mimeType;
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: [");

		if (hasKey())
			sb.append("Key/Id: ").append(getKey()).append(", ");

		sb.append("Type: ").append(mimeType).append(", ");
		sb.append("Datas: " + data);

		sb.append("]");
		return sb.toString();
	}

	public boolean hasMimeType() {
		return mimeType != null;
	}

	public boolean hasData() {
		return data != null && data.length > 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((mimeType == null) ? 0 : mimeType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MimeTypeRecord other = (MimeTypeRecord) obj;
		if (mimeType == null) {
			if (other.mimeType != null)
				return false;
		} else if (!mimeType.equals(other.mimeType))
			return false;
		if (!Arrays.equals(data, other.data))
			return false;
		return true;
	}

}
