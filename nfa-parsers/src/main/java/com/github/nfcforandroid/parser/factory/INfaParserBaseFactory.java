package com.github.nfcforandroid.parser.factory;

import com.github.nfcforandroid.api.INfaParser;

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
