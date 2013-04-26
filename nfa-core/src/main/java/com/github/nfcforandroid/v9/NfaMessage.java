package com.github.nfcforandroid.v9;

import java.util.ArrayList;
import java.util.List;

import com.github.nfcforandroid.api.INfaMessage;
import com.github.nfcforandroid.api.INfaRecord;

/**
 * @author jefBinomed Simple class that contains a list of {@link INfaRecord}
 */
class NfaMessage implements INfaMessage {

	private ArrayList<INfaRecord> recordList = new ArrayList<INfaRecord>();

	/**
	 * @param record
	 */
	public void addRecord(INfaRecord record) {
		recordList.add(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaMessage#recordList()
	 */
	public List<INfaRecord> recordList() {
		return recordList;
	}

}
