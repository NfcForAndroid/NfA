package com.greennfc.tools.parser.wkt;

import com.greennfc.tools.api.IGreenParser;

public final class WellKnowTypeFactory {

	private static WellKnowTypeFactory instance;

	private TextParser textParser;

	private WellKnowTypeFactory() {
	}

	public synchronized TextParser getTextParser() {
		if (textParser == null) {
			textParser = new TextParser();
		}
		return textParser;
	}

	private static synchronized WellKnowTypeFactory getInstance() {
		if (instance == null) {
			instance = new WellKnowTypeFactory();
		}
		return instance;
	}

	public static IGreenParser textParser() {
		return getInstance().getTextParser();
	}

}
