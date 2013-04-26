package com.github.nfcforandroid.records.factory;

import android.content.Context;
import android.net.Uri;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.records.ndef.ext.AndroidApplicationRecord;
import com.github.nfcforandroid.records.ndef.ext.ExternalRecord;
import com.github.nfcforandroid.records.ndef.ext.TextExternalRecord;
import com.github.nfcforandroid.records.ndef.ext.UriExternalRecord;

/**
 * @author jefBinomed
 * 
 * 
 *         Factory for getting {@link INfaRecord} that are External
 */
public interface INfaRecordExtFactory {

	/**
	 * @param type
	 *            the type of external data
	 * @param datas
	 *            the datas of the tag
	 * @return a new instance of {@link ExternalRecord} on each call
	 */
	ExternalRecord externalRecordInstance(String type, byte[] datas);

	/**
	 * @param type
	 *            the type of external data
	 * @param text
	 *            the text of the tag
	 * @return a new instance of {@link TextExternalRecord} on each call
	 */
	TextExternalRecord textExternalRecordInstance(String type, String text);

	/**
	 * @param type
	 *            the type of external data
	 * @param uri
	 *            the uri of the tag
	 * @return a new instance of {@link UriExternalRecord} on each call
	 */
	UriExternalRecord uriExternalRecordInstance(String type, String uri);

	/**
	 * @param type
	 *            the type of external data
	 * @param uri
	 *            the uri of the tag
	 * @return a new instance of {@link UriExternalRecord} on each call
	 */
	UriExternalRecord uriExternalRecordInstance(String type, Uri uri);

	/**
	 * @param packageName
	 *            the package name corresponding to android application
	 * @return a new instance of {@link AndroidApplicationRecord} on each call
	 */
	AndroidApplicationRecord androidApplicationRecordInstance(String packageName);

	/**
	 * @param context
	 *            the context corresponding to the android application
	 * @return a new instance of {@link AndroidApplicationRecord} on each call
	 */
	AndroidApplicationRecord androidApplicationRecordInstance(Context context);

}
