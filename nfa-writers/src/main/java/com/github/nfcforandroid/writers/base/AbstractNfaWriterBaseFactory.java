package com.github.nfcforandroid.writers.base;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.writers.factory.INfaWriterBaseFactory;
import com.github.nfcforandroid.writers.factory.NfaWriterFactory;

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
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterBaseFactory#emptyWriter()
	 */
	public INfaWriter<INfaRecord> emptyWriter() {
		if (emptyWriter == null) {
			emptyWriter = new EmptyWriter();
		}
		return emptyWriter;
	}

}
