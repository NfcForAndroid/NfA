package com.nfa.tools.filters.ndef.wkt;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.factory.INfaFilterWktFactory;
import com.nfa.tools.filters.factory.NfaFiltersFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of Well Know Types filters factory. Will be implemented in {@link NfaFiltersFactory}
 */
public abstract class AbstractNfaFilterWktFactory implements INfaFilterWktFactory {

	private TextFilter textFilter;
	private UriFilter uriFilter;

	protected AbstractNfaFilterWktFactory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.filters.factory.INfaFilterWktFactory#textFilter()
	 */
	public INfaIntentFilter textFilter() {
		if (textFilter == null) {
			textFilter = new TextFilter();
		}
		return textFilter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.filters.factory.INfaFilterWktFactory#uriFilter()
	 */
	public INfaIntentFilter uriFilter() {
		if (uriFilter == null) {
			uriFilter = new UriFilter();
		}
		return uriFilter;
	}

}
