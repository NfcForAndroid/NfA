package com.nfa.tools.records.factory;

import android.content.Context;
import android.net.Uri;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.records.ndef.ext.AndroidApplicationRecord;
import com.nfa.tools.records.ndef.ext.TextExternalRecord;
import com.nfa.tools.records.ndef.ext.UriExternalRecord;

/**
 * @author jefBinomed
 * 
 * 
 *         Factory for getting {@link INfaRecord} that are External
 */
public interface INfaRecordExtFactory {

	/**
	 * @param key
	 *            the tag identifier
	 * @param text
	 *            the text of the tag
	 * @return a new instance of {@link TextExternalRecord} on each call
	 */
	TextExternalRecord textExternalRecordInstance(String key, String text);

	/**
	 * @param text
	 *            the text of the tag
	 * @return a new instance of {@link TextExternalRecord} on each call
	 */
	TextExternalRecord textExternalRecordInstance(String text);

	/**
	 * @param uri
	 *            the uri of the tag
	 * @return a new instance of {@link UriExternalRecord} on each call
	 */
	UriExternalRecord uriExternalRecordInstance(String uri);

	/**
	 * @param key
	 *            the tag identifier
	 * @param uri
	 *            the uri of the tag
	 * @return a new instance of {@link UriExternalRecord} on each call
	 */
	UriExternalRecord uriExternalRecordInstance(String key, String uri);

	/**
	 * @param uri
	 *            the uri of the tag
	 * @return a new instance of {@link UriExternalRecord} on each call
	 */
	UriExternalRecord uriExternalRecordInstance(Uri uri);

	/**
	 * @param key
	 *            the tag identifier
	 * @param uri
	 *            the uri of the tag
	 * @return a new instance of {@link UriExternalRecord} on each call
	 */
	UriExternalRecord uriExternalRecordInstance(String key, Uri uri);

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
