package com.nfa.tools.writers;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.INfaWriter;

/**
 * @author jefBinomed
 * 
 *         Abstract class that define the standard method for the management of {@link #init(INfaRecord)}, {@link #isInit()} and {@link #reset()}
 * 
 *         An empty byte is integrated in this class for the management of empty datas
 * 
 * @param <Record>
 */
public abstract class AbstractWriter<Record extends INfaRecord> implements INfaWriter<Record> {

	protected Record record;

	protected static final byte[] EMPTY_BYTE = new byte[] {};

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaWriter#init(com.nfa.tools.api.INfaRecord)
	 */
	public void init(Record record) {
		this.record = record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaWriter#isInit()
	 */
	public boolean isInit() {
		return record != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaWriter#reset()
	 */
	public void reset() {
		record = null;
	}

}
