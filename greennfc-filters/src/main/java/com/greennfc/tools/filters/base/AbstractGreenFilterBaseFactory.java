package com.greennfc.tools.filters.base;

public class AbstractGreenFilterBaseFactory {

	// private static GreenFilterBaseFactory instance;

	private NdefFilter ndefFilter;
	private TagFilter tagFilter;
	private TechFilter techFilter;

	protected AbstractGreenFilterBaseFactory() {
	}

	public synchronized NdefFilter ndefFilter() {
		if (ndefFilter == null) {
			ndefFilter = new NdefFilter();
		}
		return ndefFilter;
	}

	public synchronized TagFilter tagFilter() {
		if (tagFilter == null) {
			tagFilter = new TagFilter();
		}
		return tagFilter;
	}

	public synchronized TechFilter techFilter() {
		if (techFilter == null) {
			techFilter = new TechFilter();
		}
		return techFilter;
	}

	// public static synchronized GreenFilterBaseFactory getInstance() {
	// if (instance == null) {
	// instance = new GreenFilterBaseFactory();
	// }
	// return instance;
	// }

}
