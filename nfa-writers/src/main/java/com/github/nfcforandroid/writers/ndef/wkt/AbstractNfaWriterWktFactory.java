package com.github.nfcforandroid.writers.ndef.wkt;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.wkt.SmartPosterRecord;
import com.github.nfcforandroid.records.ndef.wkt.TextRecord;
import com.github.nfcforandroid.records.ndef.wkt.UriRecord;
import com.github.nfcforandroid.writers.factory.INfaWriterWktFactory;
import com.github.nfcforandroid.writers.factory.NfaWriterFactory;

/**
 * @author jefBinomed
 * 
 * 
 *         Abstract class for the management of well known type writer factory. Will be implemented in {@link NfaWriterFactory}
 */
public abstract class AbstractNfaWriterWktFactory implements INfaWriterWktFactory {

	protected AbstractNfaWriterWktFactory() {
	}

	private TextWriter textWriter;
	private UriWriter uriWriter;
	private SmartPosterWriter smartPosterWriter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterWktFactory#textWriter()
	 */
	public INfaWriter<TextRecord> textWriter() {
		if (textWriter == null) {
			textWriter = new TextWriter();
		}
		return textWriter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterWktFactory#uriWriter()
	 */
	public INfaWriter<UriRecord> uriWriter() {
		if (uriWriter == null) {
			uriWriter = new UriWriter();
		}
		return uriWriter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterWktFactory#smartPosterWriter()
	 */
	public INfaWriter<SmartPosterRecord> smartPosterWriter() {
		if (smartPosterWriter == null) {
			smartPosterWriter = new SmartPosterWriter();
		}
		return smartPosterWriter;
	}

}
