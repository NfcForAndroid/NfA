package com.greennfc.tools.api;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

public interface IGreenWriter<Record extends IGreenRecord> {

	boolean isInit();

	void reset();

	void init(Record record);

	NdefMessage getNdefMessage();

	NdefRecord getNdefRecord();

	int getLength();

}
