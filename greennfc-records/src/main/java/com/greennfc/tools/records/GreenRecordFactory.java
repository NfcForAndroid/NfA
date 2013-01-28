package com.greennfc.tools.records;

import com.greennfc.tools.records.ndef.GreenNdefRecordFacory;
import com.greennfc.tools.records.ndef.ext.GreenExtRecordFactory;
import com.greennfc.tools.records.ndef.wkt.GreenWktRecordFactory;

public final class GreenRecordFactory {

	private static GreenRecordFactory instance;

	public static final synchronized GreenRecordFactory getInstance() {
		if (instance == null) {
			instance = new GreenRecordFactory();
		}
		return instance;
	}

	private EmptyRecord emptyRecord;

	public synchronized EmptyRecord emptyRecord() {
		if (emptyRecord == null) {
			emptyRecord = new EmptyRecord();
		}
		return emptyRecord;
	}

	public static GreenNdefRecordFacory ndefFactory() {
		return GreenNdefRecordFacory.getInstance();
	}

	public static GreenWktRecordFactory wellKnowTypeFactory() {
		return GreenWktRecordFactory.getInstance();
	}

	public static GreenExtRecordFactory externalFactory() {
		return GreenExtRecordFactory.getInstance();
	}

}
