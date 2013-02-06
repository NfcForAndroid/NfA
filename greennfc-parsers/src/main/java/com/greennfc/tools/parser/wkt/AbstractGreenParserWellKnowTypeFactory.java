package com.greennfc.tools.parser.wkt;

import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.parser.factory.IGreenParserWktFactory;

public abstract class AbstractGreenParserWellKnowTypeFactory implements IGreenParserWktFactory {

	private TextParser textParser;
	private UriParser uriParser;
	private SmartPosterParser smartPosterParser;

	protected AbstractGreenParserWellKnowTypeFactory() {
	}

	public IGreenParser textParser() {
		if (textParser == null) {
			textParser = new TextParser();
		}
		return textParser;
	}

	public IGreenParser uriParser() {
		if (uriParser == null) {
			uriParser = new UriParser();
		}
		return uriParser;
	}

	public IGreenParser smartPosterParser() {
		if (smartPosterParser == null) {
			smartPosterParser = new SmartPosterParser();
		}
		return smartPosterParser;
	}

}
