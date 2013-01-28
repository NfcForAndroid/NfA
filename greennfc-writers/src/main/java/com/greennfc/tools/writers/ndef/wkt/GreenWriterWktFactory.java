package com.greennfc.tools.writers.ndef.wkt;

public final class GreenWriterWktFactory {

	private static GreenWriterWktFactory instance;

	private GreenWriterWktFactory() {
	}

	public static final synchronized GreenWriterWktFactory getInstance() {
		if (instance == null) {
			instance = new GreenWriterWktFactory();
		}
		return instance;
	}

	private TextWriter textWriter;

	public synchronized TextWriter getTextWriter() {
		if (textWriter == null) {
			textWriter = new TextWriter();
		}
		return textWriter;
	}

}
