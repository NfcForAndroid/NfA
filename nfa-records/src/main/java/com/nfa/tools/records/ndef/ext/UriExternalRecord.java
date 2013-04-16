package com.nfa.tools.records.ndef.ext;

import android.net.Uri;

public class UriExternalRecord extends ExternalRecord {

	protected UriExternalRecord(String key, Uri uri) {
		this(uri);
		setKey(key);
	}

	protected UriExternalRecord(String key, String uri) {
		this(uri);
		setKey(key);
	}

	protected UriExternalRecord(Uri uri) {
		setDatas(uri.toString().getBytes());
	}

	protected UriExternalRecord(String uri) {
		setDatas(uri.getBytes());
	}

	public Uri getUri() {
		return Uri.parse(new String(getDatas()));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: [");

		if (hasKey())
			sb.append("Key/Id: ").append(getKey()).append(", ");

		sb.append("Uri: ").append(getUri()).append(", ");

		sb.append("]");
		return sb.toString();
	}

	public boolean hasText() {
		return hasDatas();
	}

}
