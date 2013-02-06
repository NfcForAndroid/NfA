package com.greennfc.tools.records.ndef.wkt;

import java.nio.charset.Charset;
import java.util.Locale;

import android.net.Uri;

import com.greennfc.tools.records.factory.IGreenRecordWktFactory;

public abstract class AbstractGreenRecordWktFactory implements IGreenRecordWktFactory {

	protected AbstractGreenRecordWktFactory() {
	}

	public TextRecord textRecordInstance(String text) {
		return new TextRecord(text);
	}

	public TextRecord textRecordInstance(String key, String text) {
		return new TextRecord(key, text);
	}

	public TextRecord textRecordInstance(String text, Locale locale) {
		return new TextRecord(text, locale);
	}

	public TextRecord textRecordInstance(String text, Charset encoding, Locale locale) {
		return new TextRecord(text, encoding, locale);
	}

	public UriRecord uriRecordInstance(String uri) {
		return new UriRecord(uri);
	}

	public UriRecord uriRecordInstance(Uri uri) {
		return new UriRecord(uri);
	}

	public SmartPosterRecord smartPosterRecordInstance(SmartPosterRecordDatas smartPosterDatas) {
		return new SmartPosterRecord(smartPosterDatas);
	}

}
