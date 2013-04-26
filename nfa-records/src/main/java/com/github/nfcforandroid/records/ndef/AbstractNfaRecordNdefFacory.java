package com.github.nfcforandroid.records.ndef;

import java.io.InputStream;

import com.github.nfcforandroid.records.factory.INfaRecordNdefFactory;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of ndef record factory. Will be implemented in {@link NfaRecordFactory}
 */
public abstract class AbstractNfaRecordNdefFacory implements INfaRecordNdefFactory {

	protected AbstractNfaRecordNdefFacory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordNdefFactory#ndefRecord(short, byte[], byte[], byte[])
	 */
	public NdefRecord ndefRecord(short tnf, byte[] id, byte[] type, byte[] payload) {
		return new NdefRecord(tnf, id, type, payload);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordNdefFactory#ndefRecord(android.nfc.NdefRecord)
	 */
	public NdefRecord ndefRecord(android.nfc.NdefRecord androidNdefRecord) {
		return new NdefRecord(androidNdefRecord);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordNdefFactory#mimeRecordInstance(java.lang.String, byte[])
	 */
	public MimeTypeRecord mimeRecordInstance(String mimeType, byte[] datas) {
		return new MimeTypeRecord(mimeType, datas);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordNdefFactory#mimeRecordInstance(java.lang.String, java.io.InputStream)
	 */
	public MimeTypeRecord mimeRecordInstance(String mimeType, InputStream is) {
		return new MimeTypeRecord(mimeType, is);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordNdefFactory#unknownRecordInstance(byte[])
	 */
	public UnknownRecord unknownRecordInstance(byte[] payload) {
		return new UnknownRecord(payload);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordNdefFactory#unsupportedRecord(short, byte[], byte[], byte[])
	 */
	public UnsupportedRecord unsupportedRecord(short tnf, byte[] id, byte[] type, byte[] payload) {
		return new UnsupportedRecord(tnf, id, type, payload);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordNdefFactory#unsupportedRecord(android.nfc.NdefRecord)
	 */
	public UnsupportedRecord unsupportedRecord(android.nfc.NdefRecord androidNdefRecord) {
		return new UnsupportedRecord(androidNdefRecord);
	}

}
