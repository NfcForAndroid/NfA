package com.greennfc.tools.parser;

import com.greennfc.tools.api.IGreenParser;

public final class GreenParserFactory {

	private static GreenParserFactory instance;

	private NdefParser ndefParser;
	private TagParser tagParser;

	private GreenParserFactory() {
	}

	public synchronized NdefParser getNdefParser() {
		if (ndefParser == null) {
			ndefParser = new NdefParser();
		}
		return ndefParser;
	}

	public synchronized TagParser getTagParser() {
		if (tagParser == null) {
			tagParser = new TagParser();
		}
		return tagParser;
	}

	private static synchronized GreenParserFactory getInstance() {
		if (instance == null) {
			instance = new GreenParserFactory();
		}
		return instance;
	}

	public static IGreenParser ndefParserInstance() {
		return getInstance().getNdefParser();
	}

	public static IGreenParser tagParserInstance() {
		return getInstance().getTagParser();
	}

}
