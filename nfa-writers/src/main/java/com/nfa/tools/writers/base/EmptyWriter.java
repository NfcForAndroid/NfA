package com.nfa.tools.writers.base;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.writers.AbstractWriter;

/**
 * @author jefBinomed
 * 
 *         {@link INfaWriter} for empty data.
 * 
 */
public class EmptyWriter extends AbstractWriter<INfaRecord> {

	protected EmptyWriter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaWriter#getLength()
	 */
	public int getLength() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaWriter#getNdefMessage()
	 */
	public NdefMessage getNdefMessage() {
		return new NdefMessage(new NdefRecord[] { getNdefRecord() });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaWriter#getNdefRecord()
	 */
	public NdefRecord getNdefRecord() {
		return new NdefRecord(NdefRecord.TNF_EMPTY, null, new byte[0], null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.writers.AbstractWriter#isInit()
	 */
	public boolean isInit() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.writers.AbstractWriter#reset()
	 */
	public void reset() {
	}

}
