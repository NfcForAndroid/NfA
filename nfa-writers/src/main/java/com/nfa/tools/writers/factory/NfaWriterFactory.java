package com.nfa.tools.writers.factory;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.MimeTypeRecord;
import com.nfa.tools.records.ndef.NdefRecord;
import com.nfa.tools.records.ndef.UnknownRecord;
import com.nfa.tools.records.ndef.UnsupportedRecord;
import com.nfa.tools.records.ndef.ext.AndroidApplicationRecord;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecord;
import com.nfa.tools.records.ndef.wkt.TextRecord;
import com.nfa.tools.records.ndef.wkt.UriRecord;
import com.nfa.tools.writers.base.AbstractNfaWriterBaseFactory;
import com.nfa.tools.writers.ndef.AbstractNfaWriterNdefFactory;
import com.nfa.tools.writers.ndef.ext.AbstractNfaWriterExternalFactory;
import com.nfa.tools.writers.ndef.wkt.AbstractNfaWriterWktFactory;

/**
 * @author jefBinomed
 * 
 * 
 *         Main factory for accessing to writers
 */
public final class NfaWriterFactory {

	private static NfaWriterFactory instance;

	/**
	 * A singleton instance of empty writer
	 */
	public static final INfaWriter<INfaRecord> EMPTY_WRITER = baseFactory().emptyWriter();

	/**
	 * A singleton instance of ndef writer
	 */
	public static final INfaWriter<NdefRecord> NDEF_WRITER = ndefFactory().ndefWriter();
	/**
	 * A singleton instance of mime type writer
	 */
	public static final INfaWriter<MimeTypeRecord> MIME_TYPE_WRITER = ndefFactory().mimeTypeWriter();
	/**
	 * A singleton instance of unknown writer
	 */
	public static final INfaWriter<UnknownRecord> UNKNOWN_WRITER = ndefFactory().unknownWriter();
	/**
	 * A singleton instance of unspported writer
	 */
	public static final INfaWriter<UnsupportedRecord> UNSUPPORTED_WRITER = ndefFactory().unsupportedWriter();

	/**
	 * A singleton instance of text writer
	 */
	public static final INfaWriter<TextRecord> TEXT_WRITER = wellKnowTypeFactory().textWriter();
	/**
	 * A singleton instance of uri writer
	 */
	public static final INfaWriter<UriRecord> URI_WRITER = wellKnowTypeFactory().uriWriter();
	/**
	 * A singleton instance of smart poster writer
	 */
	public static final INfaWriter<SmartPosterRecord> SMART_POSTER_WRITER = wellKnowTypeFactory().smartPosterWriter();

	/**
	 * A singleton instance of Android application writer
	 */
	public static final INfaWriter<AndroidApplicationRecord> ANDROID_APPLICATION_WRITER = externalFactory().androidApplicationWriter();

	private static final synchronized NfaWriterFactory getInstance() {
		if (instance == null) {
			instance = new NfaWriterFactory();
		}
		return instance;
	}

	private NfaWriterBaseFactory baseFactory;
	private NfaWriterNdefFactory ndefFactory;
	private NfaWriterWktFactory wktFactory;
	private NfaWriterExternalFactory externalFactory;

	private synchronized NfaWriterBaseFactory getBaseFactory() {
		if (baseFactory == null) {
			baseFactory = new NfaWriterBaseFactory();
		}
		return baseFactory;
	}

	private synchronized NfaWriterNdefFactory getNdefFactory() {
		if (ndefFactory == null) {
			ndefFactory = new NfaWriterNdefFactory();
		}
		return ndefFactory;
	}

	private synchronized NfaWriterWktFactory getWktFactory() {
		if (wktFactory == null) {
			wktFactory = new NfaWriterWktFactory();
		}
		return wktFactory;
	}

	private synchronized NfaWriterExternalFactory getExternalFactory() {
		if (externalFactory == null) {
			externalFactory = new NfaWriterExternalFactory();
		}
		return externalFactory;
	}

	/**
	 * @return a singleton instance of {@link INfaWriterWktFactory}
	 */
	public static INfaWriterWktFactory wellKnowTypeFactory() {
		return NfaWriterFactory.getInstance().getWktFactory();
	}

	/**
	 * @return a singleton instance of {@link INfaWriterBaseFactory}
	 */
	public static INfaWriterBaseFactory baseFactory() {
		return NfaWriterFactory.getInstance().getBaseFactory();
	}

	/**
	 * @return a singleton instance of {@link INfaWriterNdefFactory}
	 */
	public static INfaWriterNdefFactory ndefFactory() {
		return NfaWriterFactory.getInstance().getNdefFactory();
	}

	/**
	 * @return a singleton instance of {@link INfaWriterExternalFactory}
	 */
	public static INfaWriterExternalFactory externalFactory() {
		return NfaWriterFactory.getInstance().getExternalFactory();
	}

	@SuppressWarnings("unchecked")
	private static class NfaWriterBaseFactory extends AbstractNfaWriterBaseFactory {
	}

	private static class NfaWriterNdefFactory extends AbstractNfaWriterNdefFactory {

	}

	private static class NfaWriterWktFactory extends AbstractNfaWriterWktFactory {
	}

	private static class NfaWriterExternalFactory extends AbstractNfaWriterExternalFactory {
	}

}
