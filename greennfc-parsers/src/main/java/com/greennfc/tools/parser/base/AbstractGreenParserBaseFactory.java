package com.greennfc.tools.parser.base;

import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.parser.factory.IGreenParserBaseFactory;

public abstract class AbstractGreenParserBaseFactory implements IGreenParserBaseFactory {

	private NdefParser ndefParser;
	private TagParser tagParser;

	protected AbstractGreenParserBaseFactory() {
	}

	public IGreenParser ndefParser() {
		if (ndefParser == null) {
			ndefParser = new NdefParser();
		}
		return ndefParser;
	}

	public IGreenParser tagParser() {
		if (tagParser == null) {
			tagParser = new TagParser();
		}
		return tagParser;
	}

}
