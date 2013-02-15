package com.greennfc.tools.v9;

import java.util.ArrayList;
import java.util.List;

import com.greennfc.tools.api.IGreenMessage;
import com.greennfc.tools.api.IGreenRecord;

class GreenMessage implements IGreenMessage {

	private ArrayList<IGreenRecord> recordList = new ArrayList<IGreenRecord>();

	public void addRecord(IGreenRecord record) {
		recordList.add(record);
	}

	public List<IGreenRecord> recordList() {
		return recordList;
	}

}
