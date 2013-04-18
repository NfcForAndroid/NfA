package com.nfa.tools.records.factory;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.records.base.EmptyRecord;

/**
 * @author jefBinomed
 * 
 *         Factory for getting {@link INfaRecord} that are basic
 * 
 */
public interface INfaRecordBaseFactory {

	/**
	 * @return a Singleton instance of {@link EmptyRecord}
	 */
	EmptyRecord emptyRecord();

}
