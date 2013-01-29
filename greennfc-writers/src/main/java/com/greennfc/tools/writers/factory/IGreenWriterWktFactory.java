package com.greennfc.tools.writers.factory;

import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.wkt.TextRecord;

public interface IGreenWriterWktFactory {

	IGreenWriter<TextRecord> textWriter();
}
