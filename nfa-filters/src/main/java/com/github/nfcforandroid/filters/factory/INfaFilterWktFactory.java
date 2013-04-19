package com.github.nfcforandroid.filters.factory;

import com.github.nfcforandroid.api.INfaIntentFilter;

/**
 * @author jefBinomed
 * 
 *         Factory for getting {@link INfaIntentFilter} that are Well Know Types
 */
public interface INfaFilterWktFactory {

	/**
	 * @return a singleton instance for text filter (text/plain)
	 */
	INfaIntentFilter textFilter();

	/**
	 * @return a singletong instance for uri filter (http://)
	 */
	INfaIntentFilter uriFilter();

}
