package com.github.nfcforandroid.writers.ndef.wkt;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.wkt.TextRecord;
import com.github.nfcforandroid.writers.ndef.AbstractNdefWriter;

/**
 * @author jefBinomed
 * 
 * 
 *         {@link INfaWriter} for android application data.
 * 
 *         An {@link IllegalArgumentException} is thrown if there is no locale, no encoding, no text or if the language data length exceed the expected size
 */
public class TextWriter extends AbstractNdefWriter<TextRecord> {

	protected TextWriter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaWriter#getNdefRecord()
	 */
	public NdefRecord getNdefRecord() {
		if (!(record instanceof TextRecord)) {
			throw new IllegalArgumentException("Expected TextRecord but got : " + record.getClass());
		}

		if (!record.hasLocale()) {
			throw new IllegalArgumentException("Expected locale");
		}

		if (!record.hasEncoding()) {
			throw new IllegalArgumentException("Expected encoding");
		}

		if (!record.hasText()) {
			throw new IllegalArgumentException("Expected text");
		}

		byte[] languageData = (record.getLocale().getLanguage() + (record.getLocale().getCountry() == null || record.getLocale().getCountry().length() == 0 ? "" : ("-" + record.getLocale().getCountry()))).getBytes();

		if (languageData.length > TextRecord.LANGUAGE_CODE_MASK) {
			throw new IllegalArgumentException("Expected language code length <= 32 bytes, not " + languageData.length + " bytes");
		}

		byte[] textData = record.getText().getBytes(record.getEncoding());
		byte[] payload = new byte[1 + languageData.length + textData.length];

		byte status = (byte) (languageData.length | (TextRecord.UTF16.equals(record.getEncoding()) ? 0x80 : 0x00));
		payload[0] = status;
		System.arraycopy(languageData, 0, payload, 1, languageData.length);
		System.arraycopy(textData, 0, payload, 1 + languageData.length, textData.length);

		NdefRecord ndefRecord = new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, record.getId(), payload);
		return ndefRecord;
	}

}
