package com.nfa.tools.filters.ndef.wkt;

public final class UriFilter extends WellKnowFilter {

	protected UriFilter() {
	}

	@Override
	public String getDataScheme() {
		return "http";
	}

}
