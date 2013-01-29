package com.greennfc.tools.api;

import android.nfc.NdefRecord;
import android.nfc.Tag;

public interface IGreenParser {

	<Record extends IGreenRecord> Record parseNdef(NdefRecord record);

	<Record extends IGreenRecord> Record parseTag(Tag tag);

}
