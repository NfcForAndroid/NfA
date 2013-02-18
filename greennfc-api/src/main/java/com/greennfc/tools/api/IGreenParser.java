package com.greennfc.tools.api;

import android.nfc.NdefRecord;
import android.nfc.Tag;

import com.greennfc.tools.exception.ParserException;

public interface IGreenParser {

	<Record extends IGreenRecord> Record parseNdef(NdefRecord record) throws ParserException;

	<Record extends IGreenRecord> Record parseTag(Tag tag) throws ParserException;

}
