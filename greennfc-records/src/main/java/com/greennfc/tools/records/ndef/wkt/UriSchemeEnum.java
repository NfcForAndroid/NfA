package com.greennfc.tools.records.ndef.wkt;

public enum UriSchemeEnum {

	EMPTY("", 0x00), //
	HTTP_WWW("http://www.", 0x01), //
	HTTPS_WWW("https://www.", 0x02), //
	HTTP("http://", 0x03), //
	HTTPS("https://", 0x04), //
	TEL("tel:", 0x05), //
	MAILTO("mailto:", 0x06), //
	FTP_ANONYMOUS("ftp://anonymous:anonymous@", 0x07), //
	FTP_FTP("ftp://ftp.", 0x08), //
	FTPS("ftps://", 0x09), //
	SFTP("sftp://", 0x0A), //
	SMB("smb://", 0x0B), //
	NFS("nfs://", 0x0C), //
	FTP("ftp://", 0x0D), //
	DAV("dav://", 0x0E), //
	NEWS("news:", 0x0F), //
	TELNET("telnet://", 0x10), //
	IMAP("imap:", 0x11), //
	RTSP("rtsp://", 0x12), //
	URN("urn:", 0x13), //
	POP("pop:", 0x14), //
	SIP("sip:", 0x15), //
	SIPS("sips:", 0x16), //
	TFTP("tftp:", 0x17), //
	BTSPP("btspp://", 0x18), //
	BTL2CAP("btl2cap://", 0x19), //
	BTOEP("btgoep://", 0x1A), //
	TCPOBEX("tcpobex://", 0x1B), //
	IRDAOBEX("irdaobex://", 0x1C), //
	FILE("file://", 0x1D), //
	URN_EPC_ID("urn:epc:id:", 0x1E), //
	URN_EPC_TAG("urn:epc:tag:", 0x1F), //
	URN_EPC_PAT("urn:epc:pat:", 0x20), //
	URN_EPC_RAW("urn:epc:raw:", 0x21), //
	URN_EPC("urn:epc:", 0x22), //
	;

	private final String scheme;
	private final int code;

	private UriSchemeEnum(String scheme, int code) {
		this.scheme = scheme;
		this.code = code;
	}

	public String getScheme() {
		return scheme;
	}

	public int getCode() {
		return code;
	}

}
