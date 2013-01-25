package com.greennfc.tools.filters;

import com.greennfc.tools.filters.base.GreenFilterBaseFactory;
import com.greennfc.tools.filters.ndef.ext.GreenFilterExternalNdefFactory;
import com.greennfc.tools.filters.ndef.wkt.GreenFilterWellKnowTypeFactory;

public final class GreenFiltersFactory {

	public static final GreenFilterBaseFactory baseFilters() {
		return GreenFilterBaseFactory.getInstance();
	}

	public static final GreenFilterWellKnowTypeFactory wellKownFilters() {
		return GreenFilterWellKnowTypeFactory.getInstance();
	}

	public static final GreenFilterExternalNdefFactory externalFilters() {
		return GreenFilterExternalNdefFactory.getInstance();
	}

}
