package com.greennfc.tools.writers;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;

public abstract class AbstractWriter<Record extends IGreenRecord> implements IGreenWriter<Record> {

	protected Record record;

	protected static final byte[] EMPTY_BYTE = new byte[] {};

	public void init(Record record) {
		this.record = record;
	}

	public boolean isInit() {
		return record != null;
	}

	public void reset() {
		record = null;
	}

}
