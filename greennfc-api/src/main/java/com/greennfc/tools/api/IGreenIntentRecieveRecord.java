package com.greennfc.tools.api;

public interface IGreenIntentRecieveRecord<Record extends IGreenRecord> {

	void recieveRecord(Record record);

}
