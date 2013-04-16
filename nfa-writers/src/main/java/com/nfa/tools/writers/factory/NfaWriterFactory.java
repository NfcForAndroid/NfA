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

public final class NfaWriterFactory {

	private static NfaWriterFactory instance;

	public static final INfaWriter<INfaRecord> EMPTY_WRITER = baseFactory().emptyWriter();

	public static final INfaWriter<NdefRecord> NDEF_WRITER = ndefFactory().ndefWriter();
	public static final INfaWriter<MimeTypeRecord> MIME_TYPE_WRITER = ndefFactory().mimeTypeWriter();
	public static final INfaWriter<UnknownRecord> UNKNOWN_WRITER = ndefFactory().unknownWriter();
	public static final INfaWriter<UnsupportedRecord> UNSUPPORTED_WRITER = ndefFactory().unsupportedWriter();

	public static final INfaWriter<TextRecord> TEXT_WRITER = wellKnowTypeFactory().textWriter();
	public static final INfaWriter<UriRecord> URI_WRITER = wellKnowTypeFactory().uriWriter();
	public static final INfaWriter<SmartPosterRecord> SMART_POSTER_WRITER = wellKnowTypeFactory().smartPosterWriter();

	public static final INfaWriter<AndroidApplicationRecord> ANDROID_APPLICATION_WRITER = externalFactory().androidApplicationWriter();

	private static final synchronized NfaWriterFactory getInstance() {
		if (instance == null) {
			instance = new NfaWriterFactory();
		}
		return instance;
	}

	private GreenWriterBaseFactory baseFactory;
	private GreenWriterNdefFactory ndefFactory;
	private GreenWriterWktFactory wktFactory;
	private GreenWriterExternalFactory externalFactory;

	private synchronized GreenWriterBaseFactory getBaseFactory() {
		if (baseFactory == null) {
			baseFactory = new GreenWriterBaseFactory();
		}
		return baseFactory;
	}

	private synchronized GreenWriterNdefFactory getNdefFactory() {
		if (ndefFactory == null) {
			ndefFactory = new GreenWriterNdefFactory();
		}
		return ndefFactory;
	}

	private synchronized GreenWriterWktFactory getWktFactory() {
		if (wktFactory == null) {
			wktFactory = new GreenWriterWktFactory();
		}
		return wktFactory;
	}

	private synchronized GreenWriterExternalFactory getExternalFactory() {
		if (externalFactory == null) {
			externalFactory = new GreenWriterExternalFactory();
		}
		return externalFactory;
	}

	public static INfaWriterWktFactory wellKnowTypeFactory() {
		return NfaWriterFactory.getInstance().getWktFactory();
	}

	public static INfaWriterBaseFactory baseFactory() {
		return NfaWriterFactory.getInstance().getBaseFactory();
	}

	public static INfaWriterNdefFactory ndefFactory() {
		return NfaWriterFactory.getInstance().getNdefFactory();
	}

	public static INfaWriterExternalFactory externalFactory() {
		return NfaWriterFactory.getInstance().getExternalFactory();
	}

	@SuppressWarnings("unchecked")
	private static class GreenWriterBaseFactory extends AbstractNfaWriterBaseFactory {
	}

	private static class GreenWriterNdefFactory extends AbstractNfaWriterNdefFactory {

	}

	private static class GreenWriterWktFactory extends AbstractNfaWriterWktFactory {
	}

	private static class GreenWriterExternalFactory extends AbstractNfaWriterExternalFactory {
	}

}
