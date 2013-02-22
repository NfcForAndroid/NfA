package com.greennfc.tools.writers.ndef.ext;

import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.ext.AndroidApplicationRecord;
import com.greennfc.tools.writers.factory.IGreenWriterExternalFactory;

public abstract class AbstractGreenWriterExternalFactory implements IGreenWriterExternalFactory {

	protected AbstractGreenWriterExternalFactory() {
	}

	private AndroidApplicationWriter androidApplicationWriter;

	public IGreenWriter<AndroidApplicationRecord> androidApplicationWriter() {
		if (androidApplicationWriter == null) {
			androidApplicationWriter = new AndroidApplicationWriter();
		}
		return androidApplicationWriter;
	}

}
