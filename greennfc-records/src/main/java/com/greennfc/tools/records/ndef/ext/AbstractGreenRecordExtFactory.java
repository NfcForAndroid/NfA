package com.greennfc.tools.records.ndef.ext;

import com.greennfc.tools.records.factory.IGreenRecordExtFactory;

public abstract class AbstractGreenRecordExtFactory implements IGreenRecordExtFactory {

	protected AbstractGreenRecordExtFactory() {
	}

	public TextExternalRecord textExternalRecordInstance(String text) {
		return new TextExternalRecord(text);
	}

}
