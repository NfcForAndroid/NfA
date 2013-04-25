package com.github.nfcforandroid.writers.factory;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.MimeTypeRecord;
import com.github.nfcforandroid.records.ndef.NdefRecord;
import com.github.nfcforandroid.records.ndef.UnknownRecord;
import com.github.nfcforandroid.records.ndef.UnsupportedRecord;
import com.github.nfcforandroid.records.ndef.ext.AndroidApplicationRecord;
import com.github.nfcforandroid.records.ndef.ext.ExternalRecord;
import com.github.nfcforandroid.records.ndef.ext.TextExternalRecord;
import com.github.nfcforandroid.records.ndef.ext.UriExternalRecord;
import com.github.nfcforandroid.records.ndef.wkt.SmartPosterRecord;
import com.github.nfcforandroid.records.ndef.wkt.TextRecord;
import com.github.nfcforandroid.records.ndef.wkt.UriRecord;
import com.github.nfcforandroid.writers.base.AbstractNfaWriterBaseFactory;
import com.github.nfcforandroid.writers.ndef.AbstractNfaWriterNdefFactory;
import com.github.nfcforandroid.writers.ndef.ext.AbstractNfaWriterExternalFactory;
import com.github.nfcforandroid.writers.ndef.wkt.AbstractNfaWriterWktFactory;

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
	public static final INfaWriter<INfaRecord> EMPTY_WRITER = baseWriters().emptyWriter();

	/**
	 * A singleton instance of ndef writer
	 */
	public static final INfaWriter<NdefRecord> NDEF_WRITER = ndefWriters().ndefWriter();
	/**
	 * A singleton instance of mime type writer
	 */
	public static final INfaWriter<MimeTypeRecord> MIME_TYPE_WRITER = ndefWriters().mimeTypeWriter();
	/**
	 * A singleton instance of unknown writer
	 */
	public static final INfaWriter<UnknownRecord> UNKNOWN_WRITER = ndefWriters().unknownWriter();
	/**
	 * A singleton instance of unspported writer
	 */
	public static final INfaWriter<UnsupportedRecord> UNSUPPORTED_WRITER = ndefWriters().unsupportedWriter();

	/**
	 * A singleton instance of text writer
	 */
	public static final INfaWriter<TextRecord> TEXT_WRITER = wellKnowTypeWriters().textWriter();
	/**
	 * A singleton instance of uri writer
	 */
	public static final INfaWriter<UriRecord> URI_WRITER = wellKnowTypeWriters().uriWriter();
	/**
	 * A singleton instance of smart poster writer
	 */
	public static final INfaWriter<SmartPosterRecord> SMART_POSTER_WRITER = wellKnowTypeWriters().smartPosterWriter();

	/**
	 * A singleton instance of Android application writer
	 */
	public static final INfaWriter<AndroidApplicationRecord> ANDROID_APPLICATION_WRITER = externalWriters().androidApplicationWriter();
	/**
	 * A singleton instance of external writer
	 */
	public static final INfaWriter<ExternalRecord> EXTERNAL_WRITER = externalWriters().externalWriter();
	/**
	 * A singleton instance of external text writer
	 */
	public static final INfaWriter<TextExternalRecord> EXTERNAL_TEXT_WRITER = externalWriters().externalTextWriter();
	/**
	 * A singleton instance of external uri writer
	 */
	public static final INfaWriter<UriExternalRecord> EXTERNAL_URI_WRITER = externalWriters().externalUriWriter();

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
	public static INfaWriterWktFactory wellKnowTypeWriters() {
		return NfaWriterFactory.getInstance().getWktFactory();
	}

	/**
	 * @return a singleton instance of {@link INfaWriterBaseFactory}
	 */
	public static INfaWriterBaseFactory baseWriters() {
		return NfaWriterFactory.getInstance().getBaseFactory();
	}

	/**
	 * @return a singleton instance of {@link INfaWriterNdefFactory}
	 */
	public static INfaWriterNdefFactory ndefWriters() {
		return NfaWriterFactory.getInstance().getNdefFactory();
	}

	/**
	 * @return a singleton instance of {@link INfaWriterExternalFactory}
	 */
	public static INfaWriterExternalFactory externalWriters() {
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
