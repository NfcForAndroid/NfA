package com.greennfc.tools.records.ndef.wkt;

import java.nio.charset.Charset;
import java.util.Locale;

public final class GreenWktRecordFactory {

	private static GreenWktRecordFactory instance;

	private GreenWktRecordFactory() {
	}

	public static final synchronized GreenWktRecordFactory getInstance() {
		if (instance == null) {
			instance = new GreenWktRecordFactory();
		}
		return instance;
	}

	public TextRecord getTextRecord(String text) {
		return new TextRecord(text);
	}

	public TextRecord getTextRecord(String key, String text) {
		return new TextRecord(key, text);
	}

	public TextRecord getTextRecord(String text, Locale locale) {
		return new TextRecord(text, locale);
	}

	public TextRecord getTextRecord(String text, Charset encoding, Locale locale) {
		return new TextRecord(text, encoding, locale);
	}

}
