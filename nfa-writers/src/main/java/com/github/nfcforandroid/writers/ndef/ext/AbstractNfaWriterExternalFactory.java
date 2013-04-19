package com.github.nfcforandroid.writers.ndef.ext;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.ext.AndroidApplicationRecord;
import com.github.nfcforandroid.writers.factory.INfaWriterExternalFactory;
import com.github.nfcforandroid.writers.factory.NfaWriterFactory;

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
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterExternalFactory#androidApplicationWriter()
	 */
	public INfaWriter<AndroidApplicationRecord> androidApplicationWriter() {
		if (androidApplicationWriter == null) {
			androidApplicationWriter = new AndroidApplicationWriter();
		}
		return androidApplicationWriter;
	}

}
