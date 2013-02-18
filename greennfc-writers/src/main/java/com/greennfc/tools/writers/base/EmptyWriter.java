package com.greennfc.tools.writers.base;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.writers.AbstractWriter;

public class EmptyWriter extends AbstractWriter<IGreenRecord> {

	protected EmptyWriter() {
	}

	public int getLength() {
		return 0;
	}

	public NdefMessage getNdefMessage() {
		return new NdefMessage(new NdefRecord[] { getNdefRecord() });
	}

	public NdefRecord getNdefRecord() {
		return new NdefRecord(NdefRecord.TNF_EMPTY, null, new byte[0], null);
	}

	public boolean isInit() {
		return true;
	}

	public void reset() {
	}

}
