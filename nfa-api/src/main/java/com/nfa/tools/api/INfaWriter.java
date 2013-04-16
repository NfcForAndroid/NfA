package com.nfa.tools.api;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

public interface INfaWriter<Record extends INfaRecord> {

	boolean isInit();

	void reset();

	void init(Record record);

	NdefMessage getNdefMessage();

	NdefRecord getNdefRecord();

	int getLength();

}
