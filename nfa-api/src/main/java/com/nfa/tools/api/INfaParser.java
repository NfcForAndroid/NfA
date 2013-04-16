package com.nfa.tools.api;

import android.nfc.NdefRecord;
import android.nfc.Tag;

import com.nfa.tools.exception.ParserException;

public interface INfaParser {

	<Record extends INfaRecord> Record parseNdef(NdefRecord record) throws ParserException;

	<Record extends INfaRecord> Record parseTag(Tag tag) throws ParserException;

}
