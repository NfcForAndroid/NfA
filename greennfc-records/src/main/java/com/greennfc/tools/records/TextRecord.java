package com.greennfc.tools.records;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;

public class TextRecord implements IGreenRecord {

	private String message;

	public String getMessage() {
		return message;
	}

	public static final Charset UTF8 = Charset.forName("UTF-8");
	public static final Charset UTF16 = Charset.forName("UTF-16BE");

	public void decode(NdefRecord NdefRecord) {
		byte[] payload = NdefRecord.getPayload();

		ByteArrayInputStream bais = new ByteArrayInputStream(payload);

		int status = bais.read();
		byte languageCodeLength = (byte) (status & 0x1F);
		byte[] bytes = new byte[languageCodeLength];
		bais.read(bytes, 0, bytes.length);
		String languageCode = new String(bytes);

		bytes = new byte[payload.length - languageCodeLength - 1];
		bais.read(bytes, 0, bytes.length);
		byte[] textData = bytes;
		Charset textEncoding = ((status & 0x80) != 0) ? TextRecord.UTF16 : TextRecord.UTF8;

		try {
			message = new String(textData, textEncoding.name());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		// TODO Auto-generated method stub

	}

}
