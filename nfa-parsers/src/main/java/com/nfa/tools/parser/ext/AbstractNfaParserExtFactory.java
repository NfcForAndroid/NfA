package com.nfa.tools.parser.ext;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.parser.factory.INfaParserExtFactory;

public abstract class AbstractNfaParserExtFactory implements INfaParserExtFactory {

	protected AbstractNfaParserExtFactory() {

	}

	public INfaParser externalParser() {
		return new ExternalParser();
	}

	public INfaParser externalTextParser() {
		return new TextExternalParser();
	}

}
