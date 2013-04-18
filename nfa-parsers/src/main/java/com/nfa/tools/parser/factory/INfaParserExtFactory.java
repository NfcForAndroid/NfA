package com.nfa.tools.parser.factory;

import com.nfa.tools.api.INfaParser;

/**
 * @author jefBinomed
 * 
 *         Factory for getting {@link INfaParser} that are externals types
 * 
 */
public interface INfaParserExtFactory {

	/**
	 * @return a Singleton instance for external parser
	 */
	INfaParser externalParser();

	/**
	 * @return a Singleton instance for external text parser
	 */
	INfaParser externalTextParser();

}
