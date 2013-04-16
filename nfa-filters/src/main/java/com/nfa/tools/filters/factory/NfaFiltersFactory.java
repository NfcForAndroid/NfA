package com.nfa.tools.filters.factory;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.base.AbstractNfaFilterBaseFactory;
import com.nfa.tools.filters.ndef.ext.AbstractNfaFilterExtFactory;
import com.nfa.tools.filters.ndef.wkt.AbstractNfaFilterWktFactory;

public final class NfaFiltersFactory {

	public static INfaIntentFilter TEXT_FILTER = wellKownFilters().textFilter();
	public static INfaIntentFilter URI_FILTER = wellKownFilters().uriFilter();
	public static INfaIntentFilter NDEF_FILTER = baseFilters().ndefFilter();
	public static INfaIntentFilter TAG_FILTER = baseFilters().tagFilter();
	public static INfaIntentFilter TECH_FILTER = baseFilters().techFilter();

	private static NfaFiltersFactory instance;

	private NfaFiltersFactory() {
	}

	private static final synchronized NfaFiltersFactory getInstance() {
		if (instance == null) {
			instance = new NfaFiltersFactory();
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

	public static final INfaFilterBaseFactory baseFilters() {
		return NfaFiltersFactory.getInstance().getBaseFactory();
	}

	public static final INfaFilterWktFactory wellKownFilters() {
		return NfaFiltersFactory.getInstance().getWktFactory();
	}

	public static final INfaFilterExtFactory externalFilters() {
		return NfaFiltersFactory.getInstance().getExtFactory();
	}

	private static class GreenFilterBaseFactory extends AbstractNfaFilterBaseFactory {

	}

	private static class GreenFilterWellKnowTypeFactory extends AbstractNfaFilterWktFactory {
	}

	private static class GreenFilterExternalNdefFactory extends AbstractNfaFilterExtFactory {
	}

}
