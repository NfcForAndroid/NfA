package com.github.nfcforandroid.writers.ndef.wkt;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.wkt.SmartPosterRecord;
import com.github.nfcforandroid.records.ndef.wkt.TextRecord;
import com.github.nfcforandroid.records.ndef.wkt.UriRecord;
import com.github.nfcforandroid.writers.factory.NfaWriterFactory;
import com.github.nfcforandroid.writers.ndef.AbstractNdefWriter;

/**
 * @author jefBinomed
 * 
 * 
 *         {@link INfaWriter} for android application data.
 * 
 *         An {@link IllegalArgumentException} is thrown if the uri is not present
 */
public class SmartPosterWriter extends AbstractNdefWriter<SmartPosterRecord> {

	protected SmartPosterWriter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaWriter#getNdefRecord()
	 */
	public NdefRecord getNdefRecord() {
		if (!(record instanceof SmartPosterRecord)) {
			throw new IllegalArgumentException("Expected SmartPoster but got : " + record.getClass());
		}

		UriRecord uriRecord = record.getUri();
		TextRecord textRecord = record.getTitle();
		assert uriRecord != null : "The uri record could not be null on a smartposter";

		NdefRecord[] recordsArray = null;
		if (textRecord == null) {

			INfaWriter<UriRecord> uriWriter = NfaWriterFactory.wellKnowTypeFactory().uriWriter();
			uriWriter.init(uriRecord);

			recordsArray = new NdefRecord[] { //
			uriWriter.getNdefRecord() //
			};
		} else {

			INfaWriter<TextRecord> textWriter = NfaWriterFactory.wellKnowTypeFactory().textWriter();
			INfaWriter<UriRecord> uriWriter = NfaWriterFactory.wellKnowTypeFactory().uriWriter();
			textWriter.init(textRecord);
			uriWriter.init(uriRecord);

			recordsArray = new NdefRecord[] { //
			uriWriter.getNdefRecord(), //
					textWriter.getNdefRecord() //
			};
		}

		NdefMessage message = new NdefMessage(recordsArray);

		NdefRecord ndefRecord = new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_SMART_POSTER, record.getId(), message.toByteArray());

		return ndefRecord;

	}

}
