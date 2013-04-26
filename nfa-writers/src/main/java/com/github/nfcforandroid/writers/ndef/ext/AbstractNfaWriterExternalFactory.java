package com.github.nfcforandroid.writers.ndef.ext;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.ext.AndroidApplicationRecord;
import com.github.nfcforandroid.records.ndef.ext.ExternalRecord;
import com.github.nfcforandroid.records.ndef.ext.TextExternalRecord;
import com.github.nfcforandroid.records.ndef.ext.UriExternalRecord;
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
	private ExternalNdefWriter externalWriter;
	private TextExternalNdefWriter textExternalWriter;
	private UriExternalNdefWriter uriExternalWriter;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterExternalFactory#externalWriter()
	 */
	public INfaWriter<ExternalRecord> externalWriter() {
		if (externalWriter == null) {
			externalWriter = new ExternalNdefWriter();
		}
		return externalWriter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterExternalFactory#externalTextWriter()
	 */
	public INfaWriter<TextExternalRecord> externalTextWriter() {
		if (textExternalWriter == null) {
			textExternalWriter = new TextExternalNdefWriter();
		}
		return textExternalWriter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterExternalFactory#externalUriWriter()
	 */
	public INfaWriter<UriExternalRecord> externalUriWriter() {
		if (uriExternalWriter == null) {
			uriExternalWriter = new UriExternalNdefWriter();
		}
		return uriExternalWriter;
	}

}
