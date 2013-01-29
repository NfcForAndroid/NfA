package com.greennfc.tools.writers.factory;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;

public interface IGreenWriterBaseFactory {

	IGreenWriter<IGreenRecord> emptyWriter();

}
