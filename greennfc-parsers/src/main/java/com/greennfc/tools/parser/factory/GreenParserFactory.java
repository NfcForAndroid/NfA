package com.greennfc.tools.parser.factory;

import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.parser.base.AbstractGreenParserBaseFactory;
import com.greennfc.tools.parser.ext.AbstractGreenParserExtFactory;
import com.greennfc.tools.parser.wkt.AbstractGreenParserWellKnowTypeFactory;

public final class GreenParserFactory {

	private static GreenParserFactory instance;

	public static final IGreenParser NDEF_PARSER = baseFactory().ndefParser();
	public static final IGreenParser TAG_PARSER = baseFactory().tagParser();
	public static final IGreenParser TEXT_PARSER = wellKnowTypeFactory().textParser();
	public static final IGreenParser EXTERNAL_PARSER = externalFactory().externalParser();
	public static final IGreenParser EXTERNAL_TEXT_PARSER = externalFactory().externalTextParser();

	private GreenParserFactory() {
	}

	private GreenParserExternalNdefFactory extFactory;
	private GreenParserWellKnowTypeFactory wktFactory;
	private GreenParserBaseFactory baseFactory;

	private static synchronized GreenParserFactory getInstance() {
		if (instance == null) {
			instance = new GreenParserFactory();
		}
		return instance;
	}

	private synchronized GreenParserExternalNdefFactory getExtFactory() {
		if (extFactory == null) {
			extFactory = new GreenParserExternalNdefFactory();
		}
		return extFactory;
	}

	private synchronized GreenParserWellKnowTypeFactory getWktFactory() {
		if (wktFactory == null) {
			wktFactory = new GreenParserWellKnowTypeFactory();
		}
		return wktFactory;
	}

	private synchronized GreenParserBaseFactory getBaseFactory() {
		if (baseFactory == null) {
			baseFactory = new GreenParserBaseFactory();
		}
		return baseFactory;
	}

	public static IGreenParserExtFactory externalFactory() {
		return GreenParserFactory.getInstance().getExtFactory();
	}

	public static IGreenParserWktFactory wellKnowTypeFactory() {
		return GreenParserFactory.getInstance().getWktFactory();
	}

	public static IGreenParserBaseFactory baseFactory() {
		return GreenParserFactory.getInstance().getBaseFactory();
	}

	private static class GreenParserExternalNdefFactory extends AbstractGreenParserExtFactory {
	}

	private static class GreenParserWellKnowTypeFactory extends AbstractGreenParserWellKnowTypeFactory {
	}

	private static class GreenParserBaseFactory extends AbstractGreenParserBaseFactory {
	}

}
