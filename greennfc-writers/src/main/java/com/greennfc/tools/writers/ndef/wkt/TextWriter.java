package com.greennfc.tools.writers.ndef.wkt;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.wkt.TextRecord;

public class TextWriter implements IGreenWriter {

	protected TextWriter() {
	}

	public NdefMessage getMessageRecord(IGreenRecord record) {

		if (!(record instanceof TextRecord)) {
			throw new IllegalArgumentException("Expected TextRecord but got : " + record.getClass());
		}

		TextRecord txtRecord = (TextRecord) record;

		if (!txtRecord.hasLocale()) {
			throw new IllegalArgumentException("Expected locale");
		}

		if (!txtRecord.hasEncoding()) {
			throw new IllegalArgumentException("Expected encoding");
		}

		if (!txtRecord.hasText()) {
			throw new IllegalArgumentException("Expected text");
		}

		byte[] languageData = (txtRecord.getLocale().getLanguage() + (txtRecord.getLocale().getCountry() == null || txtRecord.getLocale().getCountry().length() == 0 ? "" : ("-" + txtRecord.getLocale().getCountry()))).getBytes();

		if (languageData.length > TextRecord.LANGUAGE_CODE_MASK) {
			throw new IllegalArgumentException("Expected language code length <= 32 bytes, not " + languageData.length + " bytes");
		}

		byte[] textData = txtRecord.getText().getBytes(txtRecord.getEncoding());
		byte[] payload = new byte[1 + languageData.length + textData.length];

		byte status = (byte) (languageData.length | (TextRecord.UTF16.equals(txtRecord.getEncoding()) ? 0x80 : 0x00));
		payload[0] = status;
		System.arraycopy(languageData, 0, payload, 1, languageData.length);
		System.arraycopy(textData, 0, payload, 1 + languageData.length, textData.length);

		NdefRecord ndefRecord = new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, txtRecord.getId(), payload);
		NdefRecord[] records = new NdefRecord[] { ndefRecord };
		NdefMessage msg = new NdefMessage(records);
		return msg;
	}

}
