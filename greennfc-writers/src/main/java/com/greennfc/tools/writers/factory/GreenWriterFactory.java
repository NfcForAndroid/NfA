package com.greennfc.tools.writers.factory;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.MimeTypeRecord;
import com.greennfc.tools.records.ndef.NdefRecord;
import com.greennfc.tools.records.ndef.wkt.SmartPosterRecord;
import com.greennfc.tools.records.ndef.wkt.TextRecord;
import com.greennfc.tools.records.ndef.wkt.UriRecord;
import com.greennfc.tools.writers.base.AbstractGreenWriterBaseFactory;
import com.greennfc.tools.writers.ndef.AbstractGreenWriterNdefFactory;
import com.greennfc.tools.writers.ndef.wkt.AbstractGreenWriterWktFactory;

public final class GreenWriterFactory {

	private static GreenWriterFactory instance;

	public static final IGreenWriter<IGreenRecord> EMPTY_WRITER = baseFactory().emptyWriter();

	public static final IGreenWriter<NdefRecord> NDEF_WRITER = ndefFactory().ndefWriter();
	public static final IGreenWriter<MimeTypeRecord> MIME_TYPE_WRITER = ndefFactory().mimeTypeWriter();

	public static final IGreenWriter<TextRecord> TEXT_WRITER = wellKnowTypeFactory().textWriter();
	public static final IGreenWriter<UriRecord> URI_WRITER = wellKnowTypeFactory().uriWriter();
	public static final IGreenWriter<SmartPosterRecord> SMART_POSTER_WRITER = wellKnowTypeFactory().smartPosterWriter();

	private static final synchronized GreenWriterFactory getInstance() {
		if (instance == null) {
			instance = new GreenWriterFactory();
		}
		return instance;
	}

	private GreenWriterBaseFactory baseFactory;
	private GreenWriterNdefFactory ndefFactory;
	private GreenWriterWktFactory wktFactory;

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

	public static IGreenWriterWktFactory wellKnowTypeFactory() {
		return GreenWriterFactory.getInstance().getWktFactory();
	}

	public static IGreenWriterBaseFactory baseFactory() {
		return GreenWriterFactory.getInstance().getBaseFactory();
	}

	public static IGreenWriterNdefFactory ndefFactory() {
		return GreenWriterFactory.getInstance().getNdefFactory();
	}

	@SuppressWarnings("unchecked")
	private static class GreenWriterBaseFactory extends AbstractGreenWriterBaseFactory {
	}

	private static class GreenWriterNdefFactory extends AbstractGreenWriterNdefFactory {

	}

	private static class GreenWriterWktFactory extends AbstractGreenWriterWktFactory {
	}

}
