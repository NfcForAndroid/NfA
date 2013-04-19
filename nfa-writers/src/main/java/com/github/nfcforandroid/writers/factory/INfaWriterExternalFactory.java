package com.github.nfcforandroid.writers.factory;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.ext.AndroidApplicationRecord;

/**
 * @author jefBinomed
 * 
 * 
 *         Factory for getting {@link INfaWriter} that are externals
 */
public interface INfaWriterExternalFactory {

	/**
	 * @return a singleton instance of android application record writer
	 */
	INfaWriter<AndroidApplicationRecord> androidApplicationWriter();

}
