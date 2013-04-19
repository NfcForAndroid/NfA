package com.github.nfcforandroid.writers;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.api.INfaWriter;

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
	 * @see com.github.nfcforandroid.api.INfaWriter#init(com.github.nfcforandroid.api.INfaRecord)
	 */
	public void init(Record record) {
		this.record = record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaWriter#isInit()
	 */
	public boolean isInit() {
		return record != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaWriter#reset()
	 */
	public void reset() {
		record = null;
	}

}
