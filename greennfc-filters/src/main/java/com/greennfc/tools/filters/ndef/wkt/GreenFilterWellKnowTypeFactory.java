package com.greennfc.tools.filters.ndef.wkt;

public class GreenFilterWellKnowTypeFactory {

	// private static GreenFilterWellKnowTypeFactory instance;

	private TextFilter textFilter;
	private UriFilter uriFilter;

	protected GreenFilterWellKnowTypeFactory() {
	}

	public synchronized TextFilter textFilter() {
		if (textFilter == null) {
			textFilter = new TextFilter();
		}
		return textFilter;
	}

	public synchronized UriFilter uriFilter() {
		if (uriFilter == null) {
			uriFilter = new UriFilter();
		}
		return uriFilter;
	}

	// public static synchronized GreenFilterWellKnowTypeFactory getInstance() {
	// if (instance == null) {
	// instance = new GreenFilterWellKnowTypeFactory();
	// }
	// return instance;
	// }

}
