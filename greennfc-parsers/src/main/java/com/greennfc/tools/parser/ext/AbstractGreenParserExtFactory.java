package com.greennfc.tools.parser.ext;

import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.parser.factory.IGreenParserExtFactory;

public abstract class AbstractGreenParserExtFactory implements IGreenParserExtFactory {

	protected AbstractGreenParserExtFactory() {

	}

	public IGreenParser externalParser() {
		return new ExternalParser();
	}

	public IGreenParser externalTextParser() {
		return new TextExternalParser();
	}

}
