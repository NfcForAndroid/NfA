package com.greennfc.tools.parser.ext;

import com.greennfc.tools.api.IGreenParser;

public final class GreenParserExternalNdefFactory {

	private static GreenParserExternalNdefFactory instance;

	private GreenParserExternalNdefFactory() {

	}

	public static final synchronized GreenParserExternalNdefFactory getInstance() {
		if (instance == null) {
			instance = new GreenParserExternalNdefFactory();
		}
		return instance;
	}

	public IGreenParser externalParser() {
		return new ExternalParser();
	}

	public IGreenParser externalTextParser() {
		return new TextExternalParser();
	}

}
