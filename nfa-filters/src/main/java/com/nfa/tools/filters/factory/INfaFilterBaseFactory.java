package com.nfa.tools.filters.factory;

import com.nfa.tools.api.INfaIntentFilter;

/**
 * @author jefBinomed
 * 
 *         Factory for getting {@link INfaIntentFilter} that are Basic
 * 
 */
public interface INfaFilterBaseFactory {

	/**
	 * @return a singleton instance for Ndef filter
	 */
	INfaIntentFilter ndefFilter();

	/**
	 * @return a singleton instance for tag filter
	 */
	INfaIntentFilter tagFilter();

	/**
	 * @return a singleton instance for tech filter
	 */
	INfaIntentFilter techFilter();

}
