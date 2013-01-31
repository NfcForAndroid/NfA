package com.greennfc.tools.records.ndef.ext;

public class TextExternalRecord extends ExternalRecord {

	protected TextExternalRecord(String key, String text) {
		this(text);
		setKey(key);
	}

	protected TextExternalRecord(String text) {
		setDatas(text.getBytes());
	}

	public String getMessage() {
		return new String(getDatas());
	}

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

	public boolean hasText() {
		return hasDatas();
	}

}
