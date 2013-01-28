package com.greennfc.tools.records.ndef.ext;

public final class GreenExtRecordFactory {

	private static GreenExtRecordFactory instance;

	public static final synchronized GreenExtRecordFactory getInstance() {
		if (instance == null) {
			instance = new GreenExtRecordFactory();
		}
		return instance;
	}

}
