package com.greennfc.tools.records.ndef.wkt;

import com.greennfc.tools.records.ndef.NdefRecord;

public class SmartPosterRecord extends NdefRecord {

	private TextRecord title;
	private UriRecord uri;

	protected SmartPosterRecord(TextRecord title, UriRecord uri) {
		this.title = title;
		this.uri = uri;
	}

	public SmartPosterRecord() {
	}

	public TextRecord getTitle() {
		return title;
	}

	public void setTitle(TextRecord title) {
		this.title = title;
	}

	public UriRecord getUri() {
		return uri;
	}

	public void setUri(UriRecord uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "SmartPoster: [" + getTitle() + ", " + getUri() + "]";
	}

	public boolean hasTitle() {
		return title != null;
	}

	public boolean hasUri() {
		return uri != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
