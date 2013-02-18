package com.greennfc.tools.writers.base;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.writers.factory.IGreenWriterBaseFactory;

public abstract class AbstractGreenWriterBaseFactory implements IGreenWriterBaseFactory {

	protected AbstractGreenWriterBaseFactory() {
	}

	private EmptyWriter emptyWriter;

	public IGreenWriter<IGreenRecord> emptyWriter() {
		if (emptyWriter == null) {
			emptyWriter = new EmptyWriter();
		}
		return emptyWriter;
	}

}
