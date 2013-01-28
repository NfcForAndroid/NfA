package com.greennfc.tools.writers.factory;

import com.greennfc.tools.writers.base.AbstractGreenWriterBaseFactory;
import com.greennfc.tools.writers.ndef.wkt.AbstractGreenWriterWktFactory;

public final class GreenWriterFactory {

	private static GreenWriterFactory instance;

	private static final synchronized GreenWriterFactory getInstance() {
		if (instance == null) {
			instance = new GreenWriterFactory();
		}
		return instance;
	}

	private GreenWriterBaseFactory baseFactory;
	private GreenWriterWktFactory wktFactory;

	private synchronized GreenWriterBaseFactory getBaseFactory() {
		if (baseFactory == null) {
			baseFactory = new GreenWriterBaseFactory();
		}
		return baseFactory;
	}

	private synchronized GreenWriterWktFactory getWktFactory() {
		if (wktFactory == null) {
			wktFactory = new GreenWriterWktFactory();
		}
		return wktFactory;
	}

	public static IGreenWriterWktFactory wellKnowTypeFactory() {
		return GreenWriterFactory.getInstance().getWktFactory();
	}

	public static IGreenWriterBaseFactory baseFactory() {
		return GreenWriterFactory.getInstance().getBaseFactory();
	}

	private static class GreenWriterBaseFactory extends AbstractGreenWriterBaseFactory {
	}

	private static class GreenWriterWktFactory extends AbstractGreenWriterWktFactory {
	}

}
