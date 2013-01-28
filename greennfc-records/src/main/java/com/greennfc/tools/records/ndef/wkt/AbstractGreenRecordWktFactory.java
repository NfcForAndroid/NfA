package com.greennfc.tools.records.ndef.wkt;

import java.nio.charset.Charset;
import java.util.Locale;

import com.greennfc.tools.records.factory.IGreenRecordWktFactory;

public abstract class AbstractGreenRecordWktFactory implements IGreenRecordWktFactory {

	protected AbstractGreenRecordWktFactory() {
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
