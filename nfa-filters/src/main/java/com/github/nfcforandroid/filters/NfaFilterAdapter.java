package com.github.nfcforandroid.filters;

import com.github.nfcforandroid.api.INfaIntentFilter;

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
	 * @see com.github.nfcforandroid.api.INfaIntentFilter#getDataType()
	 */
	public String getDataType() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaIntentFilter#getAction()
	 */
	public String getAction() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaIntentFilter#getDataScheme()
	 */
	public String getDataScheme() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaIntentFilter#getDataAuthorityPort()
	 */
	public String getDataAuthorityPort() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaIntentFilter#getDataAuthorityHost()
	 */
	public String getDataAuthorityHost() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaIntentFilter#getDataPath()
	 */
	public String getDataPath() {
		return null;
	}

}
