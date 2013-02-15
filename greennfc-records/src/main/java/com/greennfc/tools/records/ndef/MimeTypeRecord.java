package com.greennfc.tools.records.ndef;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import com.greennfc.tools.exception.GreenNfcRuntimeException;

public final class MimeTypeRecord extends NdefRecord {

	private String mimeType;
	private byte[] data;

	public String getMimeType() {
		return mimeType;
	}

	public byte[] getData() {
		return data;
	}

	/**
	 * The outputstream is close during this method
	 * 
	 * @param os
	 * @throws GreenNfcRuntimeException
	 *             could throw thoses kind of error if there is error during the write process
	 */
	public void write(OutputStream os) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(os);
			bos.write(data);
		} catch (IOException e) {
			throw new GreenNfcRuntimeException("Error during write datas", e);
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				throw new GreenNfcRuntimeException("Error during closing outputstream", e);
			}
		}

	}

	protected MimeTypeRecord(String mimeType, byte[] data) {
		super();
		this.mimeType = mimeType;
		this.data = data;
	}

	protected MimeTypeRecord(String mimeType, final InputStream is) {
		super();
		this.mimeType = mimeType;
		try {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = is.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}
			buffer.flush();
			this.data = buffer.toByteArray();
		} catch (IOException e) {
			throw new IllegalArgumentException("Error with input Stream", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					throw new IllegalArgumentException("Error while trying to close the inputstream", e);
				}
			}
		}
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
