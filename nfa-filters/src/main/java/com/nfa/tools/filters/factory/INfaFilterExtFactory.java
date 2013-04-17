package com.nfa.tools.filters.factory;

import com.nfa.tools.api.INfaIntentFilter;

/**
 * @author jefBinomed
 * 
 *         Factory for getting {@link INfaIntentFilter} that are externals types
 */
public interface INfaFilterExtFactory {

	/**
	 * @param path
	 * @return A new instance of filter corresponding to the path
	 */
	INfaIntentFilter externalNdefFilter(String path);

	/**
	 * @param path
	 * @return A new instance of filter for textual external tag corresponding to the path
	 */
	INfaIntentFilter textExternalNdefFilter(String path);

}
