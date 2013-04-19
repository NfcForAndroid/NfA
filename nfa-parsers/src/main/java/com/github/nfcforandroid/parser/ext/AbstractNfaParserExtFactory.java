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

	protected AbstractNfaParserExtFactory() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.factory.INfaParserExtFactory#externalParser()
	 */
	public INfaParser externalParser() {
		return new ExternalParser();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.parser.factory.INfaParserExtFactory#externalTextParser()
	 */
	public INfaParser externalTextParser() {
		return new TextExternalParser();
	}

}
