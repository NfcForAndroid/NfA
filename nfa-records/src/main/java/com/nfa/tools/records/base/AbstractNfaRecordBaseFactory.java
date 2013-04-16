package com.nfa.tools.records.base;

import com.nfa.tools.records.factory.INfaRecordBaseFactory;

public abstract class AbstractNfaRecordBaseFactory implements INfaRecordBaseFactory {

	protected AbstractNfaRecordBaseFactory() {
	}

	private EmptyRecord emptyRecord;

	public EmptyRecord emptyRecord() {
		if (emptyRecord == null) {
			emptyRecord = new EmptyRecord();
		}
		return emptyRecord;
	}

}
