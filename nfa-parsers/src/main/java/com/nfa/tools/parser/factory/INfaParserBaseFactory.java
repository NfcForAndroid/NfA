package com.nfa.tools.parser.factory;

import com.nfa.tools.api.INfaParser;

/**
 * @author jefBinomed
 * 
 *         Factory for getting {@link INfaParser} that are basic
 * 
 */
public interface INfaParserBaseFactory {

	/**
	 * @return a Singleton instance of Tag parser
	 */
	INfaParser tagParser();

}
