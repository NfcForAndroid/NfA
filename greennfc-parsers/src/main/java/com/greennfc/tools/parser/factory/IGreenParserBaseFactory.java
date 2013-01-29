package com.greennfc.tools.parser.factory;

import com.greennfc.tools.api.IGreenParser;

public interface IGreenParserBaseFactory {

	IGreenParser ndefParser();

	IGreenParser tagParser();

}
