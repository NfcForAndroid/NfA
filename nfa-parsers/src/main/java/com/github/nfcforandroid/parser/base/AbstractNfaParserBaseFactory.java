package com.github.nfcforandroid.parser.base;

import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.parser.factory.INfaParserBaseFactory;
import com.github.nfcforandroid.parser.factory.NfaParserFactory;

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
	 * @see com.github.nfcforandroid.parser.factory.INfaParserBaseFactory#tagParser()
	 */
	public INfaParser tagParser() {
		if (tagParser == null) {
			tagParser = new TagParser();
		}
		return tagParser;
	}

}
