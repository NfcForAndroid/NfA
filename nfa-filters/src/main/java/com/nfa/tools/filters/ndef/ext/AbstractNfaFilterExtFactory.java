package com.nfa.tools.filters.ndef.ext;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.factory.INfaFilterExtFactory;
import com.nfa.tools.filters.factory.NfaFiltersFactory;

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
	 * @see com.nfa.tools.filters.factory.INfaFilterExtFactory#externalNdefFilter(java.lang.String)
	 */
	public INfaIntentFilter externalNdefFilter(String path) {
		return new ExternalNdefFilter(path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.filters.factory.INfaFilterExtFactory#textExternalNdefFilter(java.lang.String)
	 */
	public INfaIntentFilter textExternalNdefFilter(String path) {
		return new TextExternalNdefFilter(path);
	}

}
