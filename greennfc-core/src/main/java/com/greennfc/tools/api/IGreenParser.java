package com.greennfc.tools.api;

import android.nfc.NdefRecord;
import android.nfc.Tag;

public interface IGreenParser {

	IGreenRecord parseNdef(NdefRecord record);

	IGreenRecord parseTag(Tag tag);

}
