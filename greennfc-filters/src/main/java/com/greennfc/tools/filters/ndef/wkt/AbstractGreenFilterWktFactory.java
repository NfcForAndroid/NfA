package com.greennfc.tools.filters.ndef.wkt;

import com.greennfc.tools.api.IGreenIntentFilter;
import com.greennfc.tools.filters.factory.IGreenFilterWktFactory;

public abstract class AbstractGreenFilterWktFactory implements IGreenFilterWktFactory {

	private TextFilter textFilter;
	private UriFilter uriFilter;

	protected AbstractGreenFilterWktFactory() {
	}

	public IGreenIntentFilter textFilter() {
		if (textFilter == null) {
			textFilter = new TextFilter();
		}
		return textFilter;
	}

	public IGreenIntentFilter uriFilter() {
		if (uriFilter == null) {
			uriFilter = new UriFilter();
		}
		return uriFilter;
	}

}
