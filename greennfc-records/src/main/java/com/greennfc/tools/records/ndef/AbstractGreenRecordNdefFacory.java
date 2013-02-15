package com.greennfc.tools.records.ndef;

import java.io.InputStream;

import com.greennfc.tools.records.factory.IGreenRecordNdefFactory;

public abstract class AbstractGreenRecordNdefFacory implements IGreenRecordNdefFactory {

	protected AbstractGreenRecordNdefFacory() {
	}

	public NdefRecord ndefRecord(short tnf, byte[] id, byte[] type, byte[] payload) {
		return new NdefRecord(tnf, id, type, payload);
	}

	public NdefRecord ndefRecord(android.nfc.NdefRecord androidNdefRecord) {
		return new NdefRecord(androidNdefRecord);
	}

	public MimeTypeRecord mimeRecordInstance(String mimeType, byte[] datas) {
		return new MimeTypeRecord(mimeType, datas);
	}

	public MimeTypeRecord mimeRecordInstance(String mimeType, InputStream is) {
		return new MimeTypeRecord(mimeType, is);
	}

}
