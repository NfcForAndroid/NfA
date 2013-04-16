package com.nfa.tools.parser.base;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.parser.factory.INfaParserBaseFactory;

public abstract class AbstractNfaParserBaseFactory implements INfaParserBaseFactory {

	private TagParser tagParser;

	protected AbstractNfaParserBaseFactory() {
	}

	public INfaParser tagParser() {
		if (tagParser == null) {
			tagParser = new TagParser();
		}
		return tagParser;
	}

}
