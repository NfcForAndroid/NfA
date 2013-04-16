package com.nfa.tools.filters.base;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.factory.INfaFilterBaseFactory;

public abstract class AbstractNfaFilterBaseFactory implements INfaFilterBaseFactory {

	private NdefFilter ndefFilter;
	private TagFilter tagFilter;
	private TechFilter techFilter;

	protected AbstractNfaFilterBaseFactory() {
	}

	public INfaIntentFilter ndefFilter() {
		if (ndefFilter == null) {
			ndefFilter = new NdefFilter();
		}
		return ndefFilter;
	}

	public INfaIntentFilter tagFilter() {
		if (tagFilter == null) {
			tagFilter = new TagFilter();
		}
		return tagFilter;
	}

	public INfaIntentFilter techFilter() {
		if (techFilter == null) {
			techFilter = new TechFilter();
		}
		return techFilter;
	}

}
