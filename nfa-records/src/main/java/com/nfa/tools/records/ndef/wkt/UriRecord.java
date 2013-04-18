package com.nfa.tools.records.ndef.wkt;

import java.nio.charset.Charset;

import android.net.Uri;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.records.AbstractRecord;
import com.nfa.tools.records.ndef.INdefRecord;

/**
 * @author jefBinomed {@link INfaRecord} for uri data.
 * 
 *         This class contains an {@link Uri} field
 */
public class UriRecord extends AbstractRecord implements INdefRecord {

	/**
	 * Default uri charset (UTF-8)
	 */
	public static final Charset DEFAULT_URI_CHARSET = Charset.forName("UTF-8");

	private Uri uri;

	protected UriRecord(Uri uri) {
		this.uri = uri;
	}

	protected UriRecord(String uriString) {
		this(Uri.parse(uriString));
	}

	/**
	 * @return the transform uri
	 */
	public Uri getUri() {
		return uri;
	}

	/**
	 * @param uri
	 */
	public void setUri(Uri uri) {
		this.uri = uri;
	}

	/**
	 * @return <code>true</code> if there is an uri, <code>false</code> else
	 */
	public boolean hasUri() {
		return uri != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.records.AbstractRecord#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.records.AbstractRecord#equals(java.lang.Object)
	 */
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
