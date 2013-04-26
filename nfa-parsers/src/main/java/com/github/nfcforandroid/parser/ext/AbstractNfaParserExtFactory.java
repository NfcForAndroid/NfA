package com.github.nfcforandroid.parser.ext;

import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.parser.factory.INfaParserExtFactory;
import com.github.nfcforandroid.parser.factory.NfaParserFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of external parser factory. Will be implemented in {@link NfaParserFactory}
 * 
 */
public abstract class AbstractNfaParserExtFactory implements INfaParserExtFactory {

	private ExternalParser externalParser;
	private TextExternalParser textExternalParser;
	private UriExternalParser uriExternalParser;
	private AndroidApplicationParser androidApplicationParser;

	protected AbstractNfaParserExtFactory() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.factory.INfaParserExtFactory#externalParser()
	 */
	public INfaParser externalParser() {
		if (externalParser == null) {
			externalParser = new ExternalParser();
		}
		return externalParser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.factory.INfaParserExtFactory#externalTextParser()
	 */
	public INfaParser externalTextParser() {
		if (textExternalParser == null) {
			textExternalParser = new TextExternalParser();
		}
		return textExternalParser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.factory.INfaParserExtFactory#externalUriParser()
	 */
	public INfaParser externalUriParser() {
		if (uriExternalParser == null) {
			uriExternalParser = new UriExternalParser();
		}
		return uriExternalParser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.factory.INfaParserExtFactory#androidApplicationParser()
	 */
	public INfaParser androidApplicationParser() {
		if (androidApplicationParser == null) {
			androidApplicationParser = new AndroidApplicationParser();
		}
		return androidApplicationParser;
	}

}
