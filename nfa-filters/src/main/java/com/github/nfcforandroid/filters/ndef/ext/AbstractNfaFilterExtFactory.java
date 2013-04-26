package com.github.nfcforandroid.filters.ndef.ext;

import com.github.nfcforandroid.api.INfaIntentFilter;
import com.github.nfcforandroid.filters.factory.INfaFilterExtFactory;
import com.github.nfcforandroid.filters.factory.NfaFiltersFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of external filters factory. Will be implemented in {@link NfaFiltersFactory}
 * 
 */
public abstract class AbstractNfaFilterExtFactory implements INfaFilterExtFactory {

	protected AbstractNfaFilterExtFactory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.filters.factory.INfaFilterExtFactory#externalNdefFilter(java.lang.String)
	 */
	public INfaIntentFilter externalNdefFilter(String path) {
		return new ExternalNdefFilter(path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.filters.factory.INfaFilterExtFactory#textExternalNdefFilter(java.lang.String)
	 */
	public INfaIntentFilter textExternalNdefFilter(String path) {
		return new TextExternalNdefFilter(path);
	}

}
