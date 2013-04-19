package com.github.nfcforandroid.records.ndef.wkt;

import java.nio.charset.Charset;
import java.util.Locale;

import android.net.Uri;

import com.github.nfcforandroid.records.factory.INfaRecordWktFactory;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of well known types record factory. Will be implemented in {@link NfaRecordFactory}
 * 
 */
public abstract class AbstractNfaRecordWktFactory implements INfaRecordWktFactory {

	protected AbstractNfaRecordWktFactory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordWktFactory#textRecordInstance(java.lang.String)
	 */
	public TextRecord textRecordInstance(String text) {
		return new TextRecord(text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordWktFactory#textRecordInstance(java.lang.String, java.lang.String)
	 */
	public TextRecord textRecordInstance(String key, String text) {
		return new TextRecord(key, text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordWktFactory#textRecordInstance(java.lang.String, java.util.Locale)
	 */
	public TextRecord textRecordInstance(String text, Locale locale) {
		return new TextRecord(text, locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordWktFactory#textRecordInstance(java.lang.String, java.nio.charset.Charset, java.util.Locale)
	 */
	public TextRecord textRecordInstance(String text, Charset encoding, Locale locale) {
		return new TextRecord(text, encoding, locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordWktFactory#uriRecordInstance(java.lang.String)
	 */
	public UriRecord uriRecordInstance(String uri) {
		return new UriRecord(uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordWktFactory#uriRecordInstance(android.net.Uri)
	 */
	public UriRecord uriRecordInstance(Uri uri) {
		return new UriRecord(uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordWktFactory#smartPosterRecordInstance(com.github.nfcforandroid.records.ndef.wkt.SmartPosterRecordDatas)
	 */
	public SmartPosterRecord smartPosterRecordInstance(SmartPosterRecordDatas smartPosterDatas) {
		return new SmartPosterRecord(smartPosterDatas);
	}

}
