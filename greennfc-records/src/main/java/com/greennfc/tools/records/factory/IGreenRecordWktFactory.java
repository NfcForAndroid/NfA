package com.greennfc.tools.records.factory;

import java.nio.charset.Charset;
import java.util.Locale;

import com.greennfc.tools.records.ndef.wkt.TextRecord;

public interface IGreenRecordWktFactory {

	TextRecord getTextRecord(String text);

	TextRecord getTextRecord(String key, String text);

	TextRecord getTextRecord(String text, Locale locale);

	TextRecord getTextRecord(String text, Charset encoding, Locale locale);

}
