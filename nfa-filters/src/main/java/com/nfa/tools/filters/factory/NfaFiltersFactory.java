package com.nfa.tools.filters.factory;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.base.AbstractNfaFilterBaseFactory;
import com.nfa.tools.filters.ndef.ext.AbstractNfaFilterExtFactory;
import com.nfa.tools.filters.ndef.wkt.AbstractNfaFilterWktFactory;

/**
 * @author jefBinomed
 * 
 *         Main factory for accessing to filters
 */
public final class NfaFiltersFactory {

	/**
	 * Singleton instance of text filter
	 */
	public static INfaIntentFilter TEXT_FILTER = wellKownFilters().textFilter();
	/**
	 * Singleton instance of uri filter
	 */
	public static INfaIntentFilter URI_FILTER = wellKownFilters().uriFilter();
	/**
	 * Singleton instance of ndef filter
	 */
	public static INfaIntentFilter NDEF_FILTER = baseFilters().ndefFilter();
	/**
	 * Singleton instance of tag filter
	 */
	public static INfaIntentFilter TAG_FILTER = baseFilters().tagFilter();
	/**
	 * Singleton instance of tech filter
	 */
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

	private NfaFilterBaseFactory baseFactory;
	private NfaFilterWellKnowTypeFactory wktFactory;
	private NfaFilterExternalNdefFactory extFactory;

	private synchronized NfaFilterBaseFactory getBaseFactory() {
		if (baseFactory == null) {
			baseFactory = new NfaFilterBaseFactory();
		}
		return baseFactory;
	}

	private synchronized NfaFilterWellKnowTypeFactory getWktFactory() {
		if (wktFactory == null) {
			wktFactory = new NfaFilterWellKnowTypeFactory();
		}
		return wktFactory;
	}

	private synchronized NfaFilterExternalNdefFactory getExtFactory() {
		if (extFactory == null) {
			extFactory = new NfaFilterExternalNdefFactory();
		}
		return extFactory;
	}

	/**
	 * @return the Factory that gives access to basic filters
	 */
	public static final INfaFilterBaseFactory baseFilters() {
		return NfaFiltersFactory.getInstance().getBaseFactory();
	}

	/**
	 * @return the factory that gives access to well known types filters
	 */
	public static final INfaFilterWktFactory wellKownFilters() {
		return NfaFiltersFactory.getInstance().getWktFactory();
	}

	/**
	 * @return the factory that gives access to external filters
	 */
	public static final INfaFilterExtFactory externalFilters() {
		return NfaFiltersFactory.getInstance().getExtFactory();
	}

	private static class NfaFilterBaseFactory extends AbstractNfaFilterBaseFactory {

	}

	private static class NfaFilterWellKnowTypeFactory extends AbstractNfaFilterWktFactory {
	}

	private static class NfaFilterExternalNdefFactory extends AbstractNfaFilterExtFactory {
	}

}
