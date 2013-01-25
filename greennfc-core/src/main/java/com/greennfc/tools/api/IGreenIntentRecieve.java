package com.greennfc.tools.api;

public interface IGreenIntentRecieve<Record extends IGreenRecord> {

	void recieveMessage(Record record);

}
