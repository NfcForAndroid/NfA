package com.greennfc.tools.writers.base;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;

public class EmptyWriter implements IGreenWriter {

	protected EmptyWriter() {
	}

	public NdefMessage getMessageRecord(IGreenRecord record) {
		return new NdefMessage(new NdefRecord[] { new NdefRecord(NdefRecord.TNF_EMPTY, null, new byte[0], null) });
	}

}
