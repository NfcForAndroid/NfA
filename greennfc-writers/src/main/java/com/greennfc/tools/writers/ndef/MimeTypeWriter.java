package com.greennfc.tools.writers.ndef;

import java.nio.charset.Charset;

import android.nfc.NdefRecord;

import com.greennfc.tools.records.ndef.MimeTypeRecord;

public class MimeTypeWriter extends NdefWriter<MimeTypeRecord> {

	public NdefRecord getNdefRecord() {
		if (!record.hasMimeType()) {
			throw new IllegalArgumentException("Expected content type ");
		}

		return new NdefRecord(NdefRecord.TNF_MIME_MEDIA, record.getMimeType().getBytes(Charset.forName("US_ASCII")), record.getId(), record.getData());
	}

}
