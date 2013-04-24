package com.github.nfcforandroid.parser.factory;

import com.github.nfcforandroid.api.INfaIntentFilter;
import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.records.ndef.ext.ExternalRecord;

/**
 * @author jefBinomed
 * 
 *         Factory for getting {@link INfaParser} that are ndef tags
 * 
 */
public interface INfaParserNdefFactory {

	/**
	 * @param the
	 *            list of intents filters to use for identifying external tags. If you don't want to manage external tags, or just get an {@link ExternalRecord}, don't fill this parameter
	 * @return a Singleton instance for Ndef parser only if filters is <code>null</code>. Else will return a new instance of NdefParser that could manage the external filters
	 */
	INfaParser ndefParser(INfaIntentFilter... filters);

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
