package com.greennfc.tools.writers;

import com.greennfc.tools.writers.ndef.wkt.GreenWriterWktFactory;

public final class GreenWriterFactory {

	private static GreenWriterFactory instance;

	public static final synchronized GreenWriterFactory getInstance() {
		if (instance == null) {
			instance = new GreenWriterFactory();
		}
		return instance;
	}

	private EmptyWriter emptyWriter;

	public synchronized EmptyWriter emptyWriter() {
		if (emptyWriter == null) {
			emptyWriter = new EmptyWriter();
		}
		return emptyWriter;
	}

	public static GreenWriterWktFactory wellKnowTypeFactory() {
		return GreenWriterWktFactory.getInstance();
	}

}
