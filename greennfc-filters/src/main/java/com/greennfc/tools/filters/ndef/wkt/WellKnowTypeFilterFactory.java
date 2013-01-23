package com.greennfc.tools.filters.ndef.wkt;

public class WellKnowTypeFilterFactory {

	private static WellKnowTypeFilterFactory instance;

	private TextFilter textFilter;

	private WellKnowTypeFilterFactory() {
	}

	private synchronized TextFilter getTextFilter() {
		if (textFilter == null) {
			textFilter = new TextFilter();
		}
		return textFilter;
	}

	private static synchronized WellKnowTypeFilterFactory getInstance() {
		if (instance == null) {
			instance = new WellKnowTypeFilterFactory();
		}
		return instance;
	}

	public static TextFilter textFilter() {
		return getInstance().getTextFilter();
	}

}
