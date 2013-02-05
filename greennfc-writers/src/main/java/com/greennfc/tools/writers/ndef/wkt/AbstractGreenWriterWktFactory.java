package com.greennfc.tools.writers.ndef.wkt;

import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.wkt.SmartPosterRecord;
import com.greennfc.tools.records.ndef.wkt.TextRecord;
import com.greennfc.tools.records.ndef.wkt.UriRecord;
import com.greennfc.tools.writers.factory.IGreenWriterWktFactory;

public abstract class AbstractGreenWriterWktFactory implements IGreenWriterWktFactory {

	protected AbstractGreenWriterWktFactory() {
	}

	private TextWriter textWriter;
	private UriWriter uriWriter;
	private SmartPosterWriter smartPosterWriter;

	public IGreenWriter<TextRecord> textWriter() {
		if (textWriter == null) {
			textWriter = new TextWriter();
		}
		return textWriter;
	}

	public IGreenWriter<UriRecord> uriWriter() {
		if (uriWriter == null) {
			uriWriter = new UriWriter();
		}
		return uriWriter;
	}

	public IGreenWriter<SmartPosterRecord> smartPosterWriter() {
		if (smartPosterWriter == null) {
			smartPosterWriter = new SmartPosterWriter();
		}
		return smartPosterWriter;
	}

}
