package com.greennfc.tools.writers.factory;

import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.ext.AndroidApplicationRecord;

public interface IGreenWriterExternalFactory {

	IGreenWriter<AndroidApplicationRecord> androidApplicationWriter();

}
