package com.nfa.tools.parser.factory;

import com.nfa.tools.api.INfaParser;

public interface INfaParserWktFactory {

	INfaParser textParser();

	INfaParser uriParser();

	INfaParser smartPosterParser();

}
