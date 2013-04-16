package com.nfa.tools.writers;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.INfaWriter;

public abstract class AbstractWriter<Record extends INfaRecord> implements INfaWriter<Record> {

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
