package com.nfa.tools.writers.base;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.writers.factory.INfaWriterBaseFactory;
import com.nfa.tools.writers.factory.NfaWriterFactory;

/**
 * @author jefBinomed
 * 
 * 
 *         Abstract class for the management of basic writer factory. Will be implemented in {@link NfaWriterFactory}
 */
public abstract class AbstractNfaWriterBaseFactory implements INfaWriterBaseFactory {

	protected AbstractNfaWriterBaseFactory() {
	}

	private EmptyWriter emptyWriter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.writers.factory.INfaWriterBaseFactory#emptyWriter()
	 */
	public INfaWriter<INfaRecord> emptyWriter() {
		if (emptyWriter == null) {
			emptyWriter = new EmptyWriter();
		}
		return emptyWriter;
	}

}
