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
	public static final INfaParser TAG_PARSER = baseParsers().tagParser();

	/**
	 * Singleton instance for Ndef tag parser
	 */
	public static final INfaParser NDEF_PARSER = ndefParsers().ndefParser();
	/**
	 * Singleton instance for mime tag parser
	 */
	public static final INfaParser MIME_TYPE_PARSER = ndefParsers().mimeTypeParser();
	/**
	 * Singleton instance for unkown tag parser
	 */
	public static final INfaParser UNKNOWN_PARSER = ndefParsers().unknownParser();
	/**
	 * Singleton instance for unsupported tag parser
	 */
	public static final INfaParser UNSUPPORTED_PARSER = ndefParsers().unsupportedParser();

	/**
	 * Singleton instance for external tag parser
	 */
	public static final INfaParser EXTERNAL_PARSER = externalParsers().externalParser();
	/**
	 * Singleton instance for external textual tag parser
	 */
	public static final INfaParser EXTERNAL_TEXT_PARSER = externalParsers().externalTextParser();
	/**
	 * Singleton instance for external textual tag parser
	 */
	public static final INfaParser EXTERNAL_URI_PARSER = externalParsers().externalUriParser();
	/**
	 * Singleton instance for external textual tag parser
	 */
	public static final INfaParser ANDROID_APPLICATION_PARSER = externalParsers().androidApplicationParser();

	/**
	 * Singleton instance for text tag parser
	 */
	public static final INfaParser TEXT_PARSER = wellKnowTypeParsers().textParser();
	/**
	 * Singleton instance for uri tag parser
	 */
	public static final INfaParser URI_PARSER = wellKnowTypeParsers().uriParser();
	/**
	 * Singleton instance for smart poster tag parser
	 */
	public static final INfaParser SMART_POSTER_PARSER = wellKnowTypeParsers().smartPosterParser();

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
	public static INfaParserExtFactory externalParsers() {
		return NfaParserFactory.getInstance().getExtFactory();
	}

	/**
	 * @return Singleton instance for well known types tags parser
	 */
	public static INfaParserWktFactory wellKnowTypeParsers() {
		return NfaParserFactory.getInstance().getWktFactory();
	}

	/**
	 * @return Singleton instance for bases tags parser
	 */
	public static INfaParserBaseFactory baseParsers() {
		return NfaParserFactory.getInstance().getBaseFactory();
	}

	/**
	 * @return Singleton instance for ndefs tags parser
	 */
	public static INfaParserNdefFactory ndefParsers() {
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
