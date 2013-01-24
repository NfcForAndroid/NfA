package com.greennfc.tools.records.ndef.wkt;

import java.nio.charset.Charset;

import android.net.Uri;

import com.greennfc.tools.records.ndef.NdefRecord;

public class UriRecord extends NdefRecord {

	public static final Charset DEFAULT_URI_CHARSET = Charset.forName("UTF-8");

	/**
	 * NFC Forum "URI Record Type Definition"
	 * <p>
	 * This is a mapping of "URI Identifier Codes" to URI string prefixes, per section 3.2.2 of the NFC Forum URI Record Type Definition document.
	 */
	@Deprecated
	public static final String[] URI_PREFIX_MAP = new String[] { "", // 0x00
			"http://www.", // 0x01
			"https://www.", // 0x02
			"http://", // 0x03
			"https://", // 0x04
			"tel:", // 0x05
			"mailto:", // 0x06
			"ftp://anonymous:anonymous@", // 0x07
			"ftp://ftp.", // 0x08
			"ftps://", // 0x09
			"sftp://", // 0x0A
			"smb://", // 0x0B
			"nfs://", // 0x0C
			"ftp://", // 0x0D
			"dav://", // 0x0E
			"news:", // 0x0F
			"telnet://", // 0x10
			"imap:", // 0x11
			"rtsp://", // 0x12
			"urn:", // 0x13
			"pop:", // 0x14
			"sip:", // 0x15
			"sips:", // 0x16
			"tftp:", // 0x17
			"btspp://", // 0x18
			"btl2cap://", // 0x19
			"btgoep://", // 0x1A
			"tcpobex://", // 0x1B
			"irdaobex://", // 0x1C
			"file://", // 0x1D
			"urn:epc:id:", // 0x1E
			"urn:epc:tag:", // 0x1F
			"urn:epc:pat:", // 0x20
			"urn:epc:raw:", // 0x21
			"urn:epc:", // 0x22
	};

	private Uri uri;

	public UriRecord(Uri uri) {
		this.uri = uri;
	}

	public UriRecord() {
	}

	public UriRecord(String uriString) {
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
