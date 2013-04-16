package com.nfa.tools.records.ndef;

import java.io.InputStream;

import com.nfa.tools.records.factory.INfaRecordNdefFactory;

public abstract class AbstractNfaRecordNdefFacory implements INfaRecordNdefFactory {

	protected AbstractNfaRecordNdefFacory() {
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

	public UnknownRecord unknownRecordInstance(byte[] payload) {
		return new UnknownRecord(payload);
	}

	public UnsupportedRecord unsupportedRecord(short tnf, byte[] id, byte[] type, byte[] payload) {
		return new UnsupportedRecord(tnf, id, type, payload);
	}

	public UnsupportedRecord unsupportedRecord(android.nfc.NdefRecord androidNdefRecord) {
		return new UnsupportedRecord(androidNdefRecord);
	}

}
