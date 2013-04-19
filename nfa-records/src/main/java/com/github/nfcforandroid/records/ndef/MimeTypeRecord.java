package com.github.nfcforandroid.records.ndef;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.exception.NfaRuntimeException;
import com.github.nfcforandroid.records.AbstractRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaRecord} for mime type data.
 * 
 *         This class contains a string for the mime type and a byte array for the datas
 */
public final class MimeTypeRecord extends AbstractRecord implements INdefRecord {

	private String mimeType;
	private byte[] data;

	/**
	 * @return the type of mime datas
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @return the datas
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * 
	 * Write the data contained in the record to an {@link OutputStream}
	 * 
	 * The outputstream is close during this method
	 * 
	 * @param os
	 *            the destination outputStream
	 * @throws NfaRuntimeException
	 *             could throw thoses kind of error if there is error during the write process
	 */
	public void write(OutputStream os) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(os);
			bos.write(data);
		} catch (IOException e) {
			throw new NfaRuntimeException("Error during write datas", e);
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				throw new NfaRuntimeException("Error during closing outputstream", e);
			}
		}

	}

	MimeTypeRecord(String mimeType, byte[] data) {
		super();
		this.mimeType = mimeType;
		this.data = data;
	}

	MimeTypeRecord(String mimeType, final InputStream is) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
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

	/**
	 * @return <code>true</code> if there is a mime type, <code>false</code> else
	 */
	public boolean hasMimeType() {
		return mimeType != null;
	}

	/**
	 * @return <code>true</code> if there is data, <code>false</code> else
	 */
	public boolean hasData() {
		return data != null && data.length > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.AbstractRecord#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((mimeType == null) ? 0 : mimeType.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.AbstractRecord#equals(java.lang.Object)
	 */
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
