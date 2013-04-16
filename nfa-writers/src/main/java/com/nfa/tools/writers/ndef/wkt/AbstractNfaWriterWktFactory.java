package com.nfa.tools.writers.ndef.wkt;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecord;
import com.nfa.tools.records.ndef.wkt.TextRecord;
import com.nfa.tools.records.ndef.wkt.UriRecord;
import com.nfa.tools.writers.factory.INfaWriterWktFactory;

public abstract class AbstractNfaWriterWktFactory implements INfaWriterWktFactory {

	protected AbstractNfaWriterWktFactory() {
	}

	private TextWriter textWriter;
	private UriWriter uriWriter;
	private SmartPosterWriter smartPosterWriter;

	public INfaWriter<TextRecord> textWriter() {
		if (textWriter == null) {
			textWriter = new TextWriter();
		}
		return textWriter;
	}

	public INfaWriter<UriRecord> uriWriter() {
		if (uriWriter == null) {
			uriWriter = new UriWriter();
		}
		return uriWriter;
	}

	public INfaWriter<SmartPosterRecord> smartPosterWriter() {
		if (smartPosterWriter == null) {
			smartPosterWriter = new SmartPosterWriter();
		}
		return smartPosterWriter;
	}

}
