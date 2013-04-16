package com.nfa.tools.records.ndef.wkt;

import java.nio.charset.Charset;

import android.net.Uri;

import com.nfa.tools.records.AbstractRecord;
import com.nfa.tools.records.ndef.INdefRecord;

public class UriRecord extends AbstractRecord implements INdefRecord {

	public static final Charset DEFAULT_URI_CHARSET = Charset.forName("UTF-8");

	private Uri uri;

	protected UriRecord(Uri uri) {
		this.uri = uri;
	}

	protected UriRecord(String uriString) {
		this(Uri.parse(uriString));
	}

	public Uri getUri() {
		return uri;
	}

	public void setUri(Uri uri) {
		this.uri = uri;
	}

	public boolean hasUri() {
		return uri != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
		UriRecord other = (UriRecord) obj;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

}
