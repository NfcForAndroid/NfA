package com.greennfc.tools.filters.ndef.wkt;

public class GreenFilterWellKnowTypeFactory {

	private static GreenFilterWellKnowTypeFactory instance;

	private TextFilter textFilter;
	private UriFilter uriFilter;

	private GreenFilterWellKnowTypeFactory() {
	}

	private synchronized TextFilter getTextFilter() {
		if (textFilter == null) {
			textFilter = new TextFilter();
		}
		return textFilter;
	}

	private synchronized UriFilter getUriFilter() {
		if (uriFilter == null) {
			uriFilter = new UriFilter();
		}
		return uriFilter;
	}

	private static synchronized GreenFilterWellKnowTypeFactory getInstance() {
		if (instance == null) {
			instance = new GreenFilterWellKnowTypeFactory();
		}
		return instance;
	}

	public static TextFilter textFilter() {
		return getInstance().getTextFilter();
	}

	public static UriFilter uriFilter() {
		return getInstance().getUriFilter();
	}

}
