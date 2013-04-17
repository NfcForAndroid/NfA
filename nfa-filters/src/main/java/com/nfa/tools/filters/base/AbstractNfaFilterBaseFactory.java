package com.nfa.tools.filters.base;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.factory.INfaFilterBaseFactory;
import com.nfa.tools.filters.factory.NfaFiltersFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of basic filters factory. Will be implemented in {@link NfaFiltersFactory}
 */
public abstract class AbstractNfaFilterBaseFactory implements INfaFilterBaseFactory {

	private NdefFilter ndefFilter;
	private TagFilter tagFilter;
	private TechFilter techFilter;

	protected AbstractNfaFilterBaseFactory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.filters.factory.INfaFilterBaseFactory#ndefFilter()
	 */
	public INfaIntentFilter ndefFilter() {
		if (ndefFilter == null) {
			ndefFilter = new NdefFilter();
		}
		return ndefFilter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.filters.factory.INfaFilterBaseFactory#tagFilter()
	 */
	public INfaIntentFilter tagFilter() {
		if (tagFilter == null) {
			tagFilter = new TagFilter();
		}
		return tagFilter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.filters.factory.INfaFilterBaseFactory#techFilter()
	 */
	public INfaIntentFilter techFilter() {
		if (techFilter == null) {
			techFilter = new TechFilter();
		}
		return techFilter;
	}

}
