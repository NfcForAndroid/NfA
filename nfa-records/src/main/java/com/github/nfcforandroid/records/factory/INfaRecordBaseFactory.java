package com.github.nfcforandroid.records.factory;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.records.base.EmptyRecord;

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
