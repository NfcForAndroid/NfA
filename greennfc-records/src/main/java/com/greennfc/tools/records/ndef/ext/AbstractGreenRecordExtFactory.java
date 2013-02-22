package com.greennfc.tools.records.ndef.ext;

import android.content.Context;
import android.net.Uri;

import com.greennfc.tools.records.factory.IGreenRecordExtFactory;

public abstract class AbstractGreenRecordExtFactory implements IGreenRecordExtFactory {

	protected AbstractGreenRecordExtFactory() {
	}

	public TextExternalRecord textExternalRecordInstance(String text) {
		return new TextExternalRecord(text);
	}

	public TextExternalRecord textExternalRecordInstance(String key, String text) {
		return new TextExternalRecord(key, text);
	}

	public UriExternalRecord uriExternalRecordInstance(String uri) {
		return new UriExternalRecord(uri);
	}

	public UriExternalRecord uriExternalRecordInstance(String key, String uri) {
		return new UriExternalRecord(key, uri);
	}

	public UriExternalRecord uriExternalRecordInstance(Uri uri) {
		return new UriExternalRecord(uri);
	}

	public UriExternalRecord uriExternalRecordInstance(String key, Uri uri) {
		return new UriExternalRecord(key, uri);
	}

	public AndroidApplicationRecord androidApplicationRecordInstance(String packageName) {
		return new AndroidApplicationRecord(packageName);
	}

	public AndroidApplicationRecord androidApplicationRecordInstance(Context context) {
		return new AndroidApplicationRecord(context);
	}

}
