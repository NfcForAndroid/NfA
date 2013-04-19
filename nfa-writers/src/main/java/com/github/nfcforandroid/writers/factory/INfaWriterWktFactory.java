package com.github.nfcforandroid.writers.factory;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.wkt.SmartPosterRecord;
import com.github.nfcforandroid.records.ndef.wkt.TextRecord;
import com.github.nfcforandroid.records.ndef.wkt.UriRecord;

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
