package com.nfa.tools.writers.factory;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.ext.AndroidApplicationRecord;

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
