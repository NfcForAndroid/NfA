package com.nfa.tools.records.factory;

import java.io.InputStream;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.records.ndef.MimeTypeRecord;
import com.nfa.tools.records.ndef.NdefRecord;
import com.nfa.tools.records.ndef.UnknownRecord;
import com.nfa.tools.records.ndef.UnsupportedRecord;

/**
 * @author jefBinomed Factory for getting {@link INfaRecord} that are ndef
 */
public interface INfaRecordNdefFactory {

	/**
	 * @param tnf
	 *            the kind of ndef message
	 * @param id
	 *            the id of the message
	 * @param type
	 *            the type of the message
	 * @param payload
	 *            the datas of the message
	 * @return a new instance of {@link NdefRecord} on each call
	 */
	NdefRecord ndefRecord(short tnf, byte[] id, byte[] type, byte[] payload);

	/**
	 * @param androidNdefRecord
	 *            an {@link android.nfc.NdefRecord}
	 * @return a new instance of {@link NdefRecord} on each call
	 */
	NdefRecord ndefRecord(android.nfc.NdefRecord androidNdefRecord);

	/**
	 * @param mimeType
	 *            the mime type of the tag
	 * @param datas
	 *            the datas of the tag
	 * @return a new instance of {@link MimeTypeRecord} on each call
	 */
	MimeTypeRecord mimeRecordInstance(String mimeType, byte[] datas);

	/**
	 * 
	 * @param mimeType
	 *            the mime type of the tag
	 * @param is
	 *            the inputstream corresponding to the datas (the inputstream is closed in this method)
	 * @return a new instance of {@link MimeTypeRecord} on each call
	 */
	MimeTypeRecord mimeRecordInstance(String mimeType, InputStream is);

	/**
	 * @param payload
	 *            the data of the tag
	 * @return a new {@link UnknownRecord} on each call
	 */
	UnknownRecord unknownRecordInstance(byte[] payload);

	/**
	 * @param tnf
	 *            the kind of datas
	 * @param id
	 *            the id of the tag
	 * @param type
	 *            the type of the tag
	 * @param payload
	 *            the datas
	 * @return a new instance of {@link UnsupportedRecord} on each call
	 */
	UnsupportedRecord unsupportedRecord(short tnf, byte[] id, byte[] type, byte[] payload);

	/**
	 * @param androidNdefRecord
	 *            an {@link android.nfc.NdefRecord}
	 * @return a new instance of {@link UnsupportedRecord} on each call
	 */
	UnsupportedRecord unsupportedRecord(android.nfc.NdefRecord androidNdefRecord);

}
