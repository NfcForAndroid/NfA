package com.github.nfcforandroid.parser.factory;

import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.parser.base.AbstractNfaParserBaseFactory;
import com.github.nfcforandroid.parser.ext.AbstractNfaParserExtFactory;
import com.github.nfcforandroid.parser.ndef.AbstractNfaParserNdefFactory;
import com.github.nfcforandroid.parser.ndef.wkt.AbstractNfaParserWellKnowTypeFactory;

/**
 * @author jefBinomed
 * 
 * 
 *         Main factory for accessing to parsers
 * 
 */
public final class NfaParserFactory {

	private static NfaParserFactory instance;

	/**
	 * Singleton instance for basic tag
	 */
	public static final INfaParser TAG_PARSER = baseFactory().tagParser();

	/**
	 * Singleton instance for Ndef tag parser
	 */
	public static final INfaParser NDEF_PARSER = ndefFactory().ndefParser();
	/**
	 * Singleton instance for mime tag parser
	 */
	public static final INfaParser MIME_TYPE_PARSER = ndefFactory().mimeTypeParser();
	/**
	 * Singleton instance for unkown tag parser
	 */
	public static final INfaParser UNKNOWN_PARSER = ndefFactory().unknownParser();
	/**
	 * Singleton instance for unsupported tag parser
	 */
	public static final INfaParser UNSUPPORTED_PARSER = ndefFactory().unsupportedParser();

	/**
	 * Singleton instance for external tag parser
	 */
	public static final INfaParser EXTERNAL_PARSER = externalFactory().externalParser();
	/**
	 * Singleton instance for external textual tag parser
	 */
	public static final INfaParser EXTERNAL_TEXT_PARSER = externalFactory().externalTextParser();

	/**
	 * Singleton instance for text tag parser
	 */
	public static final INfaParser TEXT_PARSER = wellKnowTypeFactory().textParser();
	/**
	 * Singleton instance for uri tag parser
	 */
	public static final INfaParser URI_PARSER = wellKnowTypeFactory().uriParser();
	/**
	 * Singleton instance for smart poster tag parser
	 */
	public static final INfaParser SMART_POSTER_PARSER = wellKnowTypeFactory().smartPosterParser();

	private NfaParserFactory() {
	}

	private NfaParserExternalNdefFactory extFactory;
	private NfaParserWellKnowTypeFactory wktFactory;
	private NfaParserBaseFactory baseFactory;
	private NfaParserNdefFactory ndefFactory;

	private static synchronized NfaParserFactory getInstance() {
		if (instance == null) {
			instance = new NfaParserFactory();
		}
		return instance;
	}

	private synchronized NfaParserExternalNdefFactory getExtFactory() {
		if (extFactory == null) {
			extFactory = new NfaParserExternalNdefFactory();
		}
		return extFactory;
	}

	private synchronized NfaParserWellKnowTypeFactory getWktFactory() {
		if (wktFactory == null) {
			wktFactory = new NfaParserWellKnowTypeFactory();
		}
		return wktFactory;
	}

	private synchronized NfaParserBaseFactory getBaseFactory() {
		if (baseFactory == null) {
			baseFactory = new NfaParserBaseFactory();
		}
		return baseFactory;
	}

	private synchronized NfaParserNdefFactory getNdefFactory() {
		if (ndefFactory == null) {
			ndefFactory = new NfaParserNdefFactory();
		}
		return ndefFactory;
	}

	/**
	 * @return Singleton instance for externals tags parser
	 */
	public static INfaParserExtFactory externalFactory() {
		return NfaParserFactory.getInstance().getExtFactory();
	}

	/**
	 * @return Singleton instance for well known types tags parser
	 */
	public static INfaParserWktFactory wellKnowTypeFactory() {
		return NfaParserFactory.getInstance().getWktFactory();
	}

	/**
	 * @return Singleton instance for bases tags parser
	 */
	public static INfaParserBaseFactory baseFactory() {
		return NfaParserFactory.getInstance().getBaseFactory();
	}

	/**
	 * @return Singleton instance for ndefs tags parser
	 */
	public static INfaParserNdefFactory ndefFactory() {
		return NfaParserFactory.getInstance().getNdefFactory();
	}

	private static class NfaParserExternalNdefFactory extends AbstractNfaParserExtFactory {
	}

	private static class NfaParserWellKnowTypeFactory extends AbstractNfaParserWellKnowTypeFactory {
	}

	private static class NfaParserBaseFactory extends AbstractNfaParserBaseFactory {
	}

	private static class NfaParserNdefFactory extends AbstractNfaParserNdefFactory {
	}

}
