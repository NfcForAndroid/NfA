package com.greennfc.tools.writers.ndef.wkt;

import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.wkt.TextRecord;
import com.greennfc.tools.writers.factory.IGreenWriterWktFactory;

public abstract class AbstractGreenWriterWktFactory implements IGreenWriterWktFactory {

	protected AbstractGreenWriterWktFactory() {
	}

	private TextWriter textWriter;

	public IGreenWriter<TextRecord> textWriter() {
		if (textWriter == null) {
			textWriter = new TextWriter();
		}
		return textWriter;
	}

}
