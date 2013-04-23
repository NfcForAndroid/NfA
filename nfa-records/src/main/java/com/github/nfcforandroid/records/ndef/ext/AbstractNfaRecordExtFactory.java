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
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#externalRecordInstance(java.lang.String, byte[])
	 */
	public ExternalRecord externalRecordInstance(String type, byte[] datas) {
		return new ExternalRecord(type.getBytes(), datas);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#textExternalRecordInstance(java.lang.String, java.lang.String)
	 */
	public TextExternalRecord textExternalRecordInstance(String type, String text) {
		return new TextExternalRecord(type.getBytes(), text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#uriExternalRecordInstance(java.lang.String, java.lang.String)
	 */
	public UriExternalRecord uriExternalRecordInstance(String type, String uri) {
		return new UriExternalRecord(type.getBytes(), uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordExtFactory#uriExternalRecordInstance(java.lang.String, android.net.Uri)
	 */
	public UriExternalRecord uriExternalRecordInstance(String type, Uri uri) {
		return new UriExternalRecord(type.getBytes(), uri);
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
