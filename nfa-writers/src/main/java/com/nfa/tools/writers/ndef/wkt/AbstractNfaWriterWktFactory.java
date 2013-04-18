package com.nfa.tools.writers.ndef.wkt;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecord;
import com.nfa.tools.records.ndef.wkt.TextRecord;
import com.nfa.tools.records.ndef.wkt.UriRecord;
import com.nfa.tools.writers.factory.INfaWriterWktFactory;
import com.nfa.tools.writers.factory.NfaWriterFactory;

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
	 * @see com.nfa.tools.writers.factory.INfaWriterWktFactory#textWriter()
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
	 * @see com.nfa.tools.writers.factory.INfaWriterWktFactory#uriWriter()
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
	 * @see com.nfa.tools.writers.factory.INfaWriterWktFactory#smartPosterWriter()
	 */
	public INfaWriter<SmartPosterRecord> smartPosterWriter() {
		if (smartPosterWriter == null) {
			smartPosterWriter = new SmartPosterWriter();
		}
		return smartPosterWriter;
	}

}
