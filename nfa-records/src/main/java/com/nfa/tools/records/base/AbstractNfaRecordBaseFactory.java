package com.nfa.tools.records.base;

import com.nfa.tools.records.factory.INfaRecordBaseFactory;
import com.nfa.tools.records.factory.NfaRecordFactory;

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
	 * @see com.nfa.tools.records.factory.INfaRecordBaseFactory#emptyRecord()
	 */
	public EmptyRecord emptyRecord() {
		if (emptyRecord == null) {
			emptyRecord = new EmptyRecord();
		}
		return emptyRecord;
	}

}
