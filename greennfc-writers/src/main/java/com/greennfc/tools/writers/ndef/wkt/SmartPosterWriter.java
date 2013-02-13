package com.greennfc.tools.writers.ndef.wkt;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.wkt.SmartPosterRecord;
import com.greennfc.tools.records.ndef.wkt.TextRecord;
import com.greennfc.tools.records.ndef.wkt.UriRecord;
import com.greennfc.tools.writers.factory.GreenWriterFactory;
import com.greennfc.tools.writers.ndef.NdefWriter;

public class SmartPosterWriter extends NdefWriter<SmartPosterRecord> {

	protected SmartPosterWriter() {
	}

	public NdefRecord getNdefRecord() {
		if (!(record instanceof SmartPosterRecord)) {
			throw new IllegalArgumentException("Expected SmartPoster but got : " + record.getClass());
		}

		UriRecord uriRecord = record.getUri();
		TextRecord textRecord = record.getTitle();
		assert uriRecord != null : "The uri record could not be null on a smartposter";

		NdefRecord[] recordsArray = null;
		if (textRecord == null) {

			IGreenWriter<UriRecord> uriWriter = GreenWriterFactory.wellKnowTypeFactory().uriWriter();
			uriWriter.init(uriRecord);

			recordsArray = new NdefRecord[] { //
			uriWriter.getNdefRecord() //
			};
		} else {

			IGreenWriter<TextRecord> textWriter = GreenWriterFactory.wellKnowTypeFactory().textWriter();
			IGreenWriter<UriRecord> uriWriter = GreenWriterFactory.wellKnowTypeFactory().uriWriter();
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
