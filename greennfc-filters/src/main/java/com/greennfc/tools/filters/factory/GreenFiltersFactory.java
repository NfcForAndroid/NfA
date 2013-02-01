package com.greennfc.tools.filters.factory;

import com.greennfc.tools.api.IGreenIntentFilter;
import com.greennfc.tools.filters.base.AbstractGreenFilterBaseFactory;
import com.greennfc.tools.filters.ndef.ext.AbstractGreenFilterExtFactory;
import com.greennfc.tools.filters.ndef.wkt.AbstractGreenFilterWktFactory;

public final class GreenFiltersFactory {

	public static IGreenIntentFilter TEXT_FILTER = wellKownFilters().textFilter();

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
	private GreenFilterWellKnowTypeFactory wktFactory;
	private GreenFilterExternalNdefFactory extFactory;

	private synchronized GreenFilterBaseFactory getBaseFactory() {
		if (baseFactory == null) {
			baseFactory = new GreenFilterBaseFactory();
		}
		return baseFactory;
	}

	private synchronized GreenFilterWellKnowTypeFactory getWktFactory() {
		if (wktFactory == null) {
			wktFactory = new GreenFilterWellKnowTypeFactory();
		}
		return wktFactory;
	}

	private synchronized GreenFilterExternalNdefFactory getExtFactory() {
		if (extFactory == null) {
			extFactory = new GreenFilterExternalNdefFactory();
		}
		return extFactory;
	}

	public static final IGreenFilterBaseFactory baseFilters() {
		return GreenFiltersFactory.getInstance().getBaseFactory();
	}

	public static final IGreenFilterWktFactory wellKownFilters() {
		return GreenFiltersFactory.getInstance().getWktFactory();
	}

	public static final IGreenFilterExtFactory externalFilters() {
		return GreenFiltersFactory.getInstance().getExtFactory();
	}

	private static class GreenFilterBaseFactory extends AbstractGreenFilterBaseFactory {

	}

	private static class GreenFilterWellKnowTypeFactory extends AbstractGreenFilterWktFactory {
	}

	private static class GreenFilterExternalNdefFactory extends AbstractGreenFilterExtFactory {
	}

}
