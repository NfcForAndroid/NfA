package com.greennfc.tools.parser.factory;

import com.greennfc.tools.api.IGreenParser;

public interface IGreenParserNdefFactory {

	IGreenParser ndefParser();

	IGreenParser mimeTypeParser();

	IGreenParser unknownParser();

	IGreenParser unsupportedParser();

}
