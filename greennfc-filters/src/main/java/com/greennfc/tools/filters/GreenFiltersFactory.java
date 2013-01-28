package com.greennfc.tools.filters;

import com.greennfc.tools.filters.base.AbstractGreenFilterBaseFactory;
import com.greennfc.tools.filters.ndef.ext.GreenFilterExternalNdefFactory;
import com.greennfc.tools.filters.ndef.wkt.GreenFilterWellKnowTypeFactory;

public final class GreenFiltersFactory {

	private static GreenFiltersFactory instance;

	private GreenFiltersFactory() {
	}

	private static final synchronized GreenFiltersFactory getInstance() {
		if (instance == null) {
			instance = new GreenFiltersFactory();
		}
		return instance;
	}

	private GreenFilterBaseFactory baseFactory;

	private synchronized GreenFilterBaseFactory getBaseFactory() {

	}

	public static final GreenFilterBaseFactory baseFilters() {
		if (baseFa)
			return GreenFilterBaseFactory.getInstance();
	}

	public static final GreenFilterWellKnowTypeFactory wellKownFilters() {
		return GreenFilterWellKnowTypeFactory.getInstance();
	}

	public static final GreenFilterExternalNdefFactory externalFilters() {
		return GreenFilterExternalNdefFactory.getInstance();
	}

	public static class GreenFilterBaseFactory extends AbstractGreenFilterBaseFactory {
	}

}
