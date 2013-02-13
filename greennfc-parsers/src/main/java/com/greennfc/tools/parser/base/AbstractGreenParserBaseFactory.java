package com.greennfc.tools.parser.base;

import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.parser.factory.IGreenParserBaseFactory;

public abstract class AbstractGreenParserBaseFactory implements IGreenParserBaseFactory {

	private TagParser tagParser;

	protected AbstractGreenParserBaseFactory() {
	}

	public IGreenParser tagParser() {
		if (tagParser == null) {
			tagParser = new TagParser();
		}
		return tagParser;
	}

}
