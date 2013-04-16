package com.nfa.tools.parser.factory;

import com.nfa.tools.api.INfaParser;

public interface INfaParserNdefFactory {

	INfaParser ndefParser();

	INfaParser mimeTypeParser();

	INfaParser unknownParser();

	INfaParser unsupportedParser();

}
