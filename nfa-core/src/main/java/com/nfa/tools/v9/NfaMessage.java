package com.nfa.tools.v9;

import java.util.ArrayList;
import java.util.List;

import com.nfa.tools.api.INfaMessage;
import com.nfa.tools.api.INfaRecord;

class NfaMessage implements INfaMessage {

	private ArrayList<INfaRecord> recordList = new ArrayList<INfaRecord>();

	public void addRecord(INfaRecord record) {
		recordList.add(record);
	}

	public List<INfaRecord> recordList() {
		return recordList;
	}

}
