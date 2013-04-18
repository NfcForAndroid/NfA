package com.nfa.tools.writers.ndef;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.nfa.tools.records.ndef.INdefRecord;
import com.nfa.tools.writers.AbstractWriter;

/**
 * @author jefBinomed
 * 
 *         Abstract class for defining the standard way to calculate the Ndfmessage and the length of a record
 * @param <Record>
 */
public abstract class AbstractNdefWriter<Record extends INdefRecord> extends AbstractWriter<Record> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaWriter#getNdefMessage()
	 */
	public NdefMessage getNdefMessage() {
		NdefRecord ndefRecord = getNdefRecord();
		NdefRecord[] records = new NdefRecord[] { ndefRecord };
		NdefMessage msg = new NdefMessage(records);
		return msg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaWriter#getLength()
	 */
	public int getLength() {
		NdefRecord ndefRecord = getNdefRecord();
		if (ndefRecord == null) {
			return -1;
		}

		short tnf = ndefRecord.getTnf();
		byte[] type = ndefRecord.getType();
		byte[] payload = ndefRecord.getPayload();
		byte[] id = ndefRecord.getId();

		// Tnf
		int lengthTmp = ((Short) tnf).toString().getBytes().length;
		int length = ((Short) tnf).toString().getBytes().length;
		// Type
		lengthTmp = type.length;
		length += lengthTmp;
		// Payload
		lengthTmp = payload.length;
		length += lengthTmp;
		// Id
		lengthTmp = id.length;
		length += lengthTmp;
		return length;
	}
}
