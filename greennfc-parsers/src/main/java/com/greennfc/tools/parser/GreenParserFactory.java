package com.greennfc.tools.parser;

import com.greennfc.tools.parser.ext.GreenParserExternalNdefFactory;
import com.greennfc.tools.parser.wkt.GreenParserWellKnowTypeFactory;

public final class GreenParserFactory {

	private static GreenParserFactory instance;

	private NdefParser ndefParser;
	private TagParser tagParser;

	private GreenParserFactory() {
	}

	public synchronized NdefParser ndefParser() {
		if (ndefParser == null) {
			ndefParser = new NdefParser();
		}
		return ndefParser;
	}

	public synchronized TagParser tagParser() {
		if (tagParser == null) {
			tagParser = new TagParser();
		}
		return tagParser;
	}

	public static synchronized GreenParserFactory getInstance() {
		if (instance == null) {
			instance = new GreenParserFactory();
		}
		return instance;
	}

	public static GreenParserExternalNdefFactory externalFactory() {
		return GreenParserExternalNdefFactory.getInstance();
	}

	public static GreenParserWellKnowTypeFactory wellKnowTypeFactory() {
		return GreenParserWellKnowTypeFactory.getInstance();
	}

}
