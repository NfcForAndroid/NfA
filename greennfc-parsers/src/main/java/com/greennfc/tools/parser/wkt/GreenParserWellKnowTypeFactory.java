package com.greennfc.tools.parser.wkt;


public final class GreenParserWellKnowTypeFactory {

	private static GreenParserWellKnowTypeFactory instance;

	private TextParser textParser;

	private GreenParserWellKnowTypeFactory() {
	}

	public synchronized TextParser textParser() {
		if (textParser == null) {
			textParser = new TextParser();
		}
		return textParser;
	}

	public static synchronized GreenParserWellKnowTypeFactory getInstance() {
		if (instance == null) {
			instance = new GreenParserWellKnowTypeFactory();
		}
		return instance;
	}

}
