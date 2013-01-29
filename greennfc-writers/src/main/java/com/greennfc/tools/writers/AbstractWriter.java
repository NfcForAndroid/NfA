package com.greennfc.tools.writers;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;

public abstract class AbstractWriter<Record extends IGreenRecord> implements IGreenWriter<Record> {

	protected Record record;

	public void init(Record record) {
		this.record = record;
	}

}
