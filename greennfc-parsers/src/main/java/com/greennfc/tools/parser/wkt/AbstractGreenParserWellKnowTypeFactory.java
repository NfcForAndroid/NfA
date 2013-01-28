package com.greennfc.tools.parser.wkt;

import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.parser.factory.IGreenParserWktFactory;

public abstract class AbstractGreenParserWellKnowTypeFactory implements IGreenParserWktFactory {

	private TextParser textParser;

	protected AbstractGreenParserWellKnowTypeFactory() {
	}

	public IGreenParser textParser() {
		if (textParser == null) {
			textParser = new TextParser();
		}
		return textParser;
	}

}
