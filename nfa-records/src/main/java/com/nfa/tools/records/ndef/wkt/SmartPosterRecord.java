package com.nfa.tools.records.ndef.wkt;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.records.AbstractRecord;
import com.nfa.tools.records.ndef.INdefRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaRecord} for smart poster data.
 * 
 *         the class contains an uri record and a text record. In future version, you could add more types likes mime types, ...
 * 
 * @see SmartPosterRecordDatas
 * 
 */
public class SmartPosterRecord extends AbstractRecord implements INdefRecord {

	private TextRecord title;
	private UriRecord uri;

	protected SmartPosterRecord(SmartPosterRecordDatas datas) {
		this.title = datas.getTitle();
		this.uri = datas.getUri();
	}

	/**
	 * @return the title record of smartposter
	 */
	public TextRecord getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(TextRecord title) {
		this.title = title;
	}

	/**
	 * @return the uri record of smart poster
	 */
	public UriRecord getUri() {
		return uri;
	}

	/**
	 * @param uri
	 */
	public void setUri(UriRecord uri) {
		this.uri = uri;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SmartPoster: [" + getTitle() + ", " + getUri() + "]";
	}

	/**
	 * @return <code>true</code> if the smartposter has a title, <code>false</code> else
	 */
	public boolean hasTitle() {
		return title != null;
	}

	/**
	 * @return <code>true</code> if the smartposter has an uri, <code>false</code> else
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
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		SmartPosterRecord other = (SmartPosterRecord) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

}
