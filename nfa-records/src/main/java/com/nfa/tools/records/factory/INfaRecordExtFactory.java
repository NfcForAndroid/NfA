package com.nfa.tools.records.factory;

import android.content.Context;
import android.net.Uri;

import com.nfa.tools.records.ndef.ext.AndroidApplicationRecord;
import com.nfa.tools.records.ndef.ext.TextExternalRecord;
import com.nfa.tools.records.ndef.ext.UriExternalRecord;

public interface INfaRecordExtFactory {

	TextExternalRecord textExternalRecordInstance(String key, String text);

	TextExternalRecord textExternalRecordInstance(String text);

	UriExternalRecord uriExternalRecordInstance(String uri);

	UriExternalRecord uriExternalRecordInstance(String key, String uri);

	UriExternalRecord uriExternalRecordInstance(Uri uri);

	UriExternalRecord uriExternalRecordInstance(String key, Uri uri);

	AndroidApplicationRecord androidApplicationRecordInstance(String packageName);

	AndroidApplicationRecord androidApplicationRecordInstance(Context context);

}
