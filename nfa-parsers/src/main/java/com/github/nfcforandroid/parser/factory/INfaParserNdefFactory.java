package com.github.nfcforandroid.parser.factory;

import com.github.nfcforandroid.api.INfaParser;

/**
 * @author jefBinomed
 * 
 *         Factory for getting {@link INfaParser} that are ndef tags
 * 
 */
public interface INfaParserNdefFactory {

	/**
	 * @return a Singleton instance for Ndef parser
	 */
	INfaParser ndefParser();

	/**
	 * @return a Singleton instance for Mime type parser
	 */
	INfaParser mimeTypeParser();

	/**
	 * @return a Singleton instance for unkown parser
	 */
	INfaParser unknownParser();

	/**
	 * @return a Singleton instance for unsupported parser
	 */
	INfaParser unsupportedParser();

}
