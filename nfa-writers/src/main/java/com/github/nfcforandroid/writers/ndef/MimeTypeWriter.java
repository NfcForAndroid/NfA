package com.github.nfcforandroid.writers.ndef;

import java.nio.charset.Charset;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.MimeTypeRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaWriter} for mime type data.
 * 
 *         An {@link IllegalArgumentException} is thrown if there is no mime type
 */
public class MimeTypeWriter extends AbstractNdefWriter<MimeTypeRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaWriter#getNdefRecord()
	 */
	public NdefRecord getNdefRecord() {
		if (!record.hasMimeType()) {
			throw new IllegalArgumentException("Expected content type ");
		}

		return new NdefRecord(NdefRecord.TNF_MIME_MEDIA, record.getMimeType().getBytes(Charset.forName("US_ASCII")), record.getId(), record.getData());
	}

}
