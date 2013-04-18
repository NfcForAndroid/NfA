package com.nfa.tools.writers.factory;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecord;
import com.nfa.tools.records.ndef.wkt.TextRecord;
import com.nfa.tools.records.ndef.wkt.UriRecord;

/**
 * @author jefBinomed
 * 
 * 
 *         Factory for getting {@link INfaWriter} that are well known types
 */
public interface INfaWriterWktFactory {

	/**
	 * @return a singleton instance of text writer
	 */
	INfaWriter<TextRecord> textWriter();

	/**
	 * @return a singleton instance of uri writer
	 */
	INfaWriter<UriRecord> uriWriter();

	/**
	 * @return a singleton instance of smart poster writer
	 */
	INfaWriter<SmartPosterRecord> smartPosterWriter();
}
