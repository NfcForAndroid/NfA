package com.nfa.tools.writers.factory;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.INfaWriter;

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
