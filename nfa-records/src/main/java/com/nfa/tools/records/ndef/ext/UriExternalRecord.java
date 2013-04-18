package com.nfa.tools.records.ndef.ext;

import android.net.Uri;

import com.nfa.tools.api.INfaRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaRecord} for uri external data.
 * 
 * 
 */
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

	/**
	 * @return the transform {@link Uri}
	 */
	public Uri getUri() {
		return Uri.parse(new String(getDatas()));
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

		sb.append("Uri: ").append(getUri()).append(", ");

		sb.append("]");
		return sb.toString();
	}

	/**
	 * @return <code>true</code> if there is data. <code>false</code> else
	 */
	public boolean hasText() {
		return hasDatas();
	}

}
