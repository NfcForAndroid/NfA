package com.greennfc.tools.api;

import android.nfc.NdefMessage;

public interface IGreenWriter<Record extends IGreenRecord> {

	void init(Record record);

	NdefMessage getMessageRecord();

	int getLength();

}
