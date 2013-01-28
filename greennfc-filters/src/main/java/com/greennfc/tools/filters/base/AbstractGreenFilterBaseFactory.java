package com.greennfc.tools.filters.base;

import com.greennfc.tools.api.IGreenIntentFilter;
import com.greennfc.tools.filters.factory.IGreenFilterBaseFactory;

public abstract class AbstractGreenFilterBaseFactory implements IGreenFilterBaseFactory {

	private NdefFilter ndefFilter;
	private TagFilter tagFilter;
	private TechFilter techFilter;

	protected AbstractGreenFilterBaseFactory() {
	}

	public IGreenIntentFilter ndefFilter() {
		if (ndefFilter == null) {
			ndefFilter = new NdefFilter();
		}
		return ndefFilter;
	}

	public IGreenIntentFilter tagFilter() {
		if (tagFilter == null) {
			tagFilter = new TagFilter();
		}
		return tagFilter;
	}

	public IGreenIntentFilter techFilter() {
		if (techFilter == null) {
			techFilter = new TechFilter();
		}
		return techFilter;
	}

}
