package com.nfa.tools.writers.ndef.ext;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.ext.AndroidApplicationRecord;
import com.nfa.tools.writers.factory.INfaWriterExternalFactory;
import com.nfa.tools.writers.factory.NfaWriterFactory;

/**
 * @author jefBinomed
 * 
 * 
 *         Abstract class for the management of external writer factory. Will be implemented in {@link NfaWriterFactory}
 */
public abstract class AbstractNfaWriterExternalFactory implements INfaWriterExternalFactory {

	protected AbstractNfaWriterExternalFactory() {
	}

	private AndroidApplicationWriter androidApplicationWriter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.writers.factory.INfaWriterExternalFactory#androidApplicationWriter()
	 */
	public INfaWriter<AndroidApplicationRecord> androidApplicationWriter() {
		if (androidApplicationWriter == null) {
			androidApplicationWriter = new AndroidApplicationWriter();
		}
		return androidApplicationWriter;
	}

}
