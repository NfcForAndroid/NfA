package com.greennfc.tools.records.base;

import com.greennfc.tools.records.factory.IGreenRecordBaseFactory;

public abstract class AbstractGreenRecordBaseFactory implements IGreenRecordBaseFactory {

	protected AbstractGreenRecordBaseFactory() {
	}

	private EmptyRecord emptyRecord;

	public EmptyRecord emptyRecord() {
		if (emptyRecord == null) {
			emptyRecord = new EmptyRecord();
		}
		return emptyRecord;
	}

}
