package com.greennfc.tools.records.factory;

import android.net.Uri;

import com.greennfc.tools.records.ndef.ext.TextExternalRecord;
import com.greennfc.tools.records.ndef.ext.UriExternalRecord;

public interface IGreenRecordExtFactory {

	TextExternalRecord textExternalRecordInstance(String key, String text);

	TextExternalRecord textExternalRecordInstance(String text);

	UriExternalRecord uriExternalRecordInstance(String uri);

	UriExternalRecord uriExternalRecordInstance(String key, String uri);

	UriExternalRecord uriExternalRecordInstance(Uri uri);

	UriExternalRecord uriExternalRecordInstance(String key, Uri uri);

}
