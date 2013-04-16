package com.nfa.tools.records.factory;

import java.nio.charset.Charset;
import java.util.Locale;

import android.net.Uri;

import com.nfa.tools.records.ndef.wkt.SmartPosterRecord;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecordDatas;
import com.nfa.tools.records.ndef.wkt.TextRecord;
import com.nfa.tools.records.ndef.wkt.UriRecord;

public interface INfaRecordWktFactory {

	TextRecord textRecordInstance(String text);

	TextRecord textRecordInstance(String key, String text);

	TextRecord textRecordInstance(String text, Locale locale);

	TextRecord textRecordInstance(String text, Charset encoding, Locale locale);

	UriRecord uriRecordInstance(String uri);

	UriRecord uriRecordInstance(Uri uri);

	SmartPosterRecord smartPosterRecordInstance(SmartPosterRecordDatas smartPosterDatas);

}
