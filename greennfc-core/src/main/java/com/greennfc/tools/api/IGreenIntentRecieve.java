package com.greennfc.tools.api;

public interface IGreenIntentRecieve<Record extends IGreenRecord> {

	void startRecieveMessage();

	void recieveMessage(Record record);

}
