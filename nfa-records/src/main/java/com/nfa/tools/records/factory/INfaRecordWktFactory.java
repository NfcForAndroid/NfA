package com.nfa.tools.records.factory;

import java.nio.charset.Charset;
import java.util.Locale;

import android.net.Uri;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecord;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecordDatas;
import com.nfa.tools.records.ndef.wkt.TextRecord;
import com.nfa.tools.records.ndef.wkt.UriRecord;

/**
 * @author jefBinomed
 * 
 *         Factory for getting {@link INfaRecord} that are well known types
 */
public interface INfaRecordWktFactory {

	/**
	 * @param text
	 *            the text of the tag
	 * @return a new instance of {@link TextRecord} on each call
	 */
	TextRecord textRecordInstance(String text);

	/**
	 * @param key
	 *            the tag identifier
	 * @param text
	 *            the text of the tag
	 * @return a new instance of {@link TextRecord} on each call
	 */
	TextRecord textRecordInstance(String key, String text);

	/**
	 * @param text
	 *            the text of the tag
	 * @param locale
	 *            the locale of the text
	 * @return a new instance of {@link TextRecord} on each call
	 */
	TextRecord textRecordInstance(String text, Locale locale);

	/**
	 * @param text
	 *            the data contained
	 * @param encoding
	 *            the specify encoding (UTF-8 or UTF-16)
	 * @param locale
	 *            the locale of the text
	 * @return a new instance of {@link TextRecord} on each call
	 */
	TextRecord textRecordInstance(String text, Charset encoding, Locale locale);

	/**
	 * @param uri
	 *            the uri of the tag
	 * @return a new instance of {@link UriRecord} on each call
	 */
	UriRecord uriRecordInstance(String uri);

	/**
	 * @param uri
	 *            the uri of the tag
	 * @return a new instance of {@link UriRecord} on each call
	 */
	UriRecord uriRecordInstance(Uri uri);

	/**
	 * @param smartPosterDatas
	 *            the datas of the smart poster (including the uri)
	 * @return a new instance of {@link SmartPosterRecord} on each call
	 */
	SmartPosterRecord smartPosterRecordInstance(SmartPosterRecordDatas smartPosterDatas);

}
