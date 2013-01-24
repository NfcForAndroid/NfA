package com.greennfc.tools.parser.wkt;

import com.greennfc.tools.api.IGreenParser;

public final class GreenParserWellKnowTypeFactory {

	private static GreenParserWellKnowTypeFactory instance;

	private TextParser textParser;

	private GreenParserWellKnowTypeFactory() {
	}

	public synchronized TextParser getTextParser() {
		if (textParser == null) {
			textParser = new TextParser();
		}
		return textParser;
	}

	private static synchronized GreenParserWellKnowTypeFactory getInstance() {
		if (instance == null) {
			instance = new GreenParserWellKnowTypeFactory();
		}
		return instance;
	}

	public static IGreenParser textParser() {
		return getInstance().getTextParser();
	}

}
