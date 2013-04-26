package com.github.nfcforandroid.records.ndef.ext;

import com.github.nfcforandroid.api.INfaRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaRecord} for text external data.
 * 
 */
public final class TextExternalRecord extends ExternalRecord {

	protected TextExternalRecord(byte[] type, String text) {
		super(type, text.getBytes());
	}

	/**
	 * @return the data contained on the tag
	 */
	public String getMessage() {
		return new String(getDatas());
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

		sb.append("Text: ").append(getMessage()).append(", ");

		sb.append("]");
		return sb.toString();
	}

	/**
	 * @return <code>true</code> if there is datas, <code>false</code> else
	 */
	public boolean hasText() {
		return hasDatas();
	}

}
