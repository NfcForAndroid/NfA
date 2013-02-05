package com.greennfc.tools.writers.factory;

import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.wkt.SmartPosterRecord;
import com.greennfc.tools.records.ndef.wkt.TextRecord;
import com.greennfc.tools.records.ndef.wkt.UriRecord;

public interface IGreenWriterWktFactory {

	IGreenWriter<TextRecord> textWriter();

	IGreenWriter<UriRecord> uriWriter();

	IGreenWriter<SmartPosterRecord> smartPosterWriter();
}
