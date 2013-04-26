package com.github.nfcforandroid.records.base;

import com.github.nfcforandroid.records.factory.INfaRecordBaseFactory;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of basic record factory. Will be implemented in {@link NfaRecordFactory}
 */
public abstract class AbstractNfaRecordBaseFactory implements INfaRecordBaseFactory {

	protected AbstractNfaRecordBaseFactory() {
	}

	private EmptyRecord emptyRecord;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.factory.INfaRecordBaseFactory#emptyRecord()
	 */
	public EmptyRecord emptyRecord() {
		if (emptyRecord == null) {
			emptyRecord = new EmptyRecord();
		}
		return emptyRecord;
	}

}
