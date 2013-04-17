package com.nfa.tools.api;

import android.content.IntentFilter;

/**
 * @author jefBinomed
 * 
 *         This interface is used when you want to create a new kind of nfc filter.
 * 
 *         A default implementation exists in the nfa-filters module : <code>com.nfa.tools.filters.NfaFilterAdapter</code>
 * 
 */
public interface INfaIntentFilter {

	/**
	 * @return The datatype of the filter. Use to specify the data types.
	 */
	String getDataType();

	/**
	 * @return the kind of action of filter (could not be null). This refers the action field of an {@link IntentFilter}
	 */
	String getAction();

	/**
	 * @return the data scheme to filter.
	 */
	String getDataScheme();

	/**
	 * @return the data port to filter.
	 */
	String getDataAuthorityPort();

	/**
	 * @return the data host.
	 */
	String getDataAuthorityHost();

	/**
	 * @return the data path. To use with the External Nfc Tags
	 */
	String getDataPath();

}
