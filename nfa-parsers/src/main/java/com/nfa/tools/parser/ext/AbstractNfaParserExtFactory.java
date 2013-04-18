package com.nfa.tools.parser.ext;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.parser.factory.INfaParserExtFactory;
import com.nfa.tools.parser.factory.NfaParserFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of external parser factory. Will be implemented in {@link NfaParserFactory}
 * 
 */
public abstract class AbstractNfaParserExtFactory implements INfaParserExtFactory {

	protected AbstractNfaParserExtFactory() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.factory.INfaParserExtFactory#externalParser()
	 */
	public INfaParser externalParser() {
		return new ExternalParser();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.factory.INfaParserExtFactory#externalTextParser()
	 */
	public INfaParser externalTextParser() {
		return new TextExternalParser();
	}

}
