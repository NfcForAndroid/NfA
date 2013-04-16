package com.nfa.tools.parser.ndef.wkt;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.parser.factory.INfaParserWktFactory;

public abstract class AbstractNfaParserWellKnowTypeFactory implements INfaParserWktFactory {

	private TextParser textParser;
	private UriParser uriParser;
	private SmartPosterParser smartPosterParser;

	protected AbstractNfaParserWellKnowTypeFactory() {
	}

	public INfaParser textParser() {
		if (textParser == null) {
			textParser = new TextParser();
		}
		return textParser;
	}

	public INfaParser uriParser() {
		if (uriParser == null) {
			uriParser = new UriParser();
		}
		return uriParser;
	}

	public INfaParser smartPosterParser() {
		if (smartPosterParser == null) {
			smartPosterParser = new SmartPosterParser();
		}
		return smartPosterParser;
	}

}
