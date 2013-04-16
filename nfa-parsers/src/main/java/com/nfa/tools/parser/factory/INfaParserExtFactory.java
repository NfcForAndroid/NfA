package com.nfa.tools.parser.factory;

import com.nfa.tools.api.INfaParser;

public interface INfaParserExtFactory {

	INfaParser externalParser();

	INfaParser externalTextParser();

}
