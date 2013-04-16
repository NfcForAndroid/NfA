package com.nfa.tools.records.factory;

import java.io.InputStream;

import com.nfa.tools.records.ndef.MimeTypeRecord;
import com.nfa.tools.records.ndef.NdefRecord;
import com.nfa.tools.records.ndef.UnknownRecord;
import com.nfa.tools.records.ndef.UnsupportedRecord;

public interface INfaRecordNdefFactory {

	NdefRecord ndefRecord(short tnf, byte[] id, byte[] type, byte[] payload);

	NdefRecord ndefRecord(android.nfc.NdefRecord androidNdefRecord);

	MimeTypeRecord mimeRecordInstance(String mimeType, byte[] datas);

	/**
	 * The inputstream is closed in this method
	 * 
	 * @param mimeType
	 * @param is
	 * @return
	 */
	MimeTypeRecord mimeRecordInstance(String mimeType, InputStream is);

	UnknownRecord unknownRecordInstance(byte[] payload);

	UnsupportedRecord unsupportedRecord(short tnf, byte[] id, byte[] type, byte[] payload);

	UnsupportedRecord unsupportedRecord(android.nfc.NdefRecord androidNdefRecord);

}