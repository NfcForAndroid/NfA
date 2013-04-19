package com.github.nfcforandroid.records.ndef.ext;

import android.content.Context;
import android.net.Uri;

import com.github.nfcforandroid.records.factory.INfaRecordExtFactory;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;

/**
 * @author jefBinomed
 * 
 * 
 *         Abstract class for the management of external record factory. Will be implemented in {@link NfaRecordFactory}
 */
public abstract class AbstractNfaRecordExtFactory implements INfaRecordExtFactory {

	protected AbstractNfaRecordExtFactory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#textExternalRecordInstance(java.lang.String)
	 */
	public TextExternalRecord textExternalRecordInstance(String text) {
		return new TextExternalRecord(text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#textExternalRecordInstance(java.lang.String, java.lang.String)
	 */
	public TextExternalRecord textExternalRecordInstance(String key, String text) {
		return new TextExternalRecord(key, text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#uriExternalRecordInstance(java.lang.String)
	 */
	public UriExternalRecord uriExternalRecordInstance(String uri) {
		return new UriExternalRecord(uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#uriExternalRecordInstance(java.lang.String, java.lang.String)
	 */
	public UriExternalRecord uriExternalRecordInstance(String key, String uri) {
		return new UriExternalRecord(key, uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#uriExternalRecordInstance(android.net.Uri)
	 */
	public UriExternalRecord uriExternalRecordInstance(Uri uri) {
		return new UriExternalRecord(uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#uriExternalRecordInstance(java.lang.String, android.net.Uri)
	 */
	public UriExternalRecord uriExternalRecordInstance(String key, Uri uri) {
		return new UriExternalRecord(key, uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#androidApplicationRecordInstance(java.lang.String)
	 */
	public AndroidApplicationRecord androidApplicationRecordInstance(String packageName) {
		return new AndroidApplicationRecord(packageName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#androidApplicationRecordInstance(android.content.Context)
	 */
	public AndroidApplicationRecord androidApplicationRecordInstance(Context context) {
		return new AndroidApplicationRecord(context);
	}

}
