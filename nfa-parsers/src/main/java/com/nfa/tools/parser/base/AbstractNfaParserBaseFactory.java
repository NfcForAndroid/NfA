package com.nfa.tools.parser.base;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.parser.factory.INfaParserBaseFactory;
import com.nfa.tools.parser.factory.NfaParserFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of basic parser factory. Will be implemented in {@link NfaParserFactory}
 * 
 */
public abstract class AbstractNfaParserBaseFactory implements INfaParserBaseFactory {

	private TagParser tagParser;

	protected AbstractNfaParserBaseFactory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.factory.INfaParserBaseFactory#tagParser()
	 */
	public INfaParser tagParser() {
		if (tagParser == null) {
			tagParser = new TagParser();
		}
		return tagParser;
	}

}
