package com.github.nfcforandroid.parser.factory;

import com.github.nfcforandroid.api.INfaParser;

/**
 * @author jefBinomed
 * 
 *         Factory for getting {@link INfaParser} that are well known types
 */
public interface INfaParserWktFactory {

	/**
	 * @return a Singleton instance of Text parser
	 */
	INfaParser textParser();

	/**
	 * @return a Singleton instance of Uri parser
	 */
	INfaParser uriParser();

	/**
	 * @return a Singleton instance of Smart Poster parser
	 */
	INfaParser smartPosterParser();

}
