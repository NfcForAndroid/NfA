package com.nfa.tools.parser.ndef.wkt;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.parser.factory.INfaParserWktFactory;
import com.nfa.tools.parser.factory.NfaParserFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of well known types parser factory. Will be implemented in {@link NfaParserFactory}
 * 
 */
public abstract class AbstractNfaParserWellKnowTypeFactory implements INfaParserWktFactory {

	private TextParser textParser;
	private UriParser uriParser;
	private SmartPosterParser smartPosterParser;

	protected AbstractNfaParserWellKnowTypeFactory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.factory.INfaParserWktFactory#textParser()
	 */
	public INfaParser textParser() {
		if (textParser == null) {
			textParser = new TextParser();
		}
		return textParser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.factory.INfaParserWktFactory#uriParser()
	 */
	public INfaParser uriParser() {
		if (uriParser == null) {
			uriParser = new UriParser();
		}
		return uriParser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.factory.INfaParserWktFactory#smartPosterParser()
	 */
	public INfaParser smartPosterParser() {
		if (smartPosterParser == null) {
			smartPosterParser = new SmartPosterParser();
		}
		return smartPosterParser;
	}

}
