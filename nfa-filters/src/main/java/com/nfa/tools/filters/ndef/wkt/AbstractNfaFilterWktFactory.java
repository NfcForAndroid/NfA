package com.nfa.tools.filters.ndef.wkt;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.factory.INfaFilterWktFactory;

public abstract class AbstractNfaFilterWktFactory implements INfaFilterWktFactory {

	private TextFilter textFilter;
	private UriFilter uriFilter;

	protected AbstractNfaFilterWktFactory() {
	}

	public INfaIntentFilter textFilter() {
		if (textFilter == null) {
			textFilter = new TextFilter();
		}
		return textFilter;
	}

	public INfaIntentFilter uriFilter() {
		if (uriFilter == null) {
			uriFilter = new UriFilter();
		}
		return uriFilter;
	}

}
