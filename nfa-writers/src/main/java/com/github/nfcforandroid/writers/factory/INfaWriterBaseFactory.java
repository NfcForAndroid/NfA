package com.github.nfcforandroid.writers.factory;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.api.INfaWriter;

/**
 * @author jefBinomed
 * 
 * 
 *         Factory for getting {@link INfaWriter} that are basic
 */
public interface INfaWriterBaseFactory {

	/**
	 * @return a singleton instance of empty writer
	 */
	INfaWriter<INfaRecord> emptyWriter();

}
