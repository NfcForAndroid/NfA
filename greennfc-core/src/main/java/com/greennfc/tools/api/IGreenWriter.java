package com.greennfc.tools.api;

import android.nfc.NdefMessage;

public interface IGreenWriter {

	NdefMessage getMessageRecord(IGreenRecord record);

}
