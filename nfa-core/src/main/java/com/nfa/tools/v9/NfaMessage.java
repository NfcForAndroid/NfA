package com.nfa.tools.v9;

import java.util.ArrayList;
import java.util.List;

import com.nfa.tools.api.INfaMessage;
import com.nfa.tools.api.INfaRecord;

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
	 * @see com.nfa.tools.api.INfaMessage#recordList()
	 */
	public List<INfaRecord> recordList() {
		return recordList;
	}

}
