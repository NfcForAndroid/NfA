package com.nfa.tools.parser.factory;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.parser.base.AbstractNfaParserBaseFactory;
import com.nfa.tools.parser.ext.AbstractNfaParserExtFactory;
import com.nfa.tools.parser.ndef.AbstractNfaParserNdefFactory;
import com.nfa.tools.parser.ndef.wkt.AbstractNfaParserWellKnowTypeFactory;

public final class NfaParserFactory {

	private static NfaParserFactory instance;

	public static final INfaParser TAG_PARSER = baseFactory().tagParser();

	public static final INfaParser NDEF_PARSER = ndefFactory().ndefParser();
	public static final INfaParser MIME_TYPE_PARSER = ndefFactory().mimeTypeParser();
	public static final INfaParser UNKNOWN_PARSER = ndefFactory().unknownParser();
	public static final INfaParser UNSUPPORTED_PARSER = ndefFactory().unsupportedParser();

	public static final INfaParser EXTERNAL_PARSER = externalFactory().externalParser();
	public static final INfaParser EXTERNAL_TEXT_PARSER = externalFactory().externalTextParser();

	public static final INfaParser TEXT_PARSER = wellKnowTypeFactory().textParser();
	public static final INfaParser URI_PARSER = wellKnowTypeFactory().uriParser();
	public static final INfaParser SMART_POSTER_PARSER = wellKnowTypeFactory().smartPosterParser();

	private NfaParserFactory() {
	}

	private GreenParserExternalNdefFactory extFactory;
	private GreenParserWellKnowTypeFactory wktFactory;
	private GreenParserBaseFactory baseFactory;
	private GreenParserNdefFactory ndefFactory;

	private static synchronized NfaParserFactory getInstance() {
		if (instance == null) {
			instance = new NfaParserFactory();
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

	private synchronized GreenParserNdefFactory getNdefFactory() {
		if (ndefFactory == null) {
			ndefFactory = new GreenParserNdefFactory();
		}
		return ndefFactory;
	}

	public static INfaParserExtFactory externalFactory() {
		return NfaParserFactory.getInstance().getExtFactory();
	}

	public static INfaParserWktFactory wellKnowTypeFactory() {
		return NfaParserFactory.getInstance().getWktFactory();
	}

	public static INfaParserBaseFactory baseFactory() {
		return NfaParserFactory.getInstance().getBaseFactory();
	}

	public static INfaParserNdefFactory ndefFactory() {
		return NfaParserFactory.getInstance().getNdefFactory();
	}

	private static class GreenParserExternalNdefFactory extends AbstractNfaParserExtFactory {
	}

	private static class GreenParserWellKnowTypeFactory extends AbstractNfaParserWellKnowTypeFactory {
	}

	private static class GreenParserBaseFactory extends AbstractNfaParserBaseFactory {
	}

	private static class GreenParserNdefFactory extends AbstractNfaParserNdefFactory {
	}

}
