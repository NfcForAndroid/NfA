package com.nfa.tools.filters;

import com.nfa.tools.api.INfaIntentFilter;

/**
 * @author jefBinomed
 * 
 *         Adapter class that represent a {@link INfaIntentFilter}
 * 
 *         all getters returns <code>null</code>
 */
public abstract class NfaFilterAdapter implements INfaIntentFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaIntentFilter#getDataType()
	 */
	public String getDataType() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaIntentFilter#getAction()
	 */
	public String getAction() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaIntentFilter#getDataScheme()
	 */
	public String getDataScheme() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaIntentFilter#getDataAuthorityPort()
	 */
	public String getDataAuthorityPort() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaIntentFilter#getDataAuthorityHost()
	 */
	public String getDataAuthorityHost() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.api.INfaIntentFilter#getDataPath()
	 */
	public String getDataPath() {
		return null;
	}

}
