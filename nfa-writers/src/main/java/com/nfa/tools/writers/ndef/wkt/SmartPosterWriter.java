package com.nfa.tools.writers.ndef.wkt;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecord;
import com.nfa.tools.records.ndef.wkt.TextRecord;
import com.nfa.tools.records.ndef.wkt.UriRecord;
import com.nfa.tools.writers.factory.NfaWriterFactory;
import com.nfa.tools.writers.ndef.AbstractNdefWriter;

public class SmartPosterWriter extends AbstractNdefWriter<SmartPosterRecord> {

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
