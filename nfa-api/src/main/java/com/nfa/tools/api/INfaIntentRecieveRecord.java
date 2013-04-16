package com.nfa.tools.api;

public interface INfaIntentRecieveRecord<Record extends INfaRecord> {

	void recieveRecord(Record record);

}
