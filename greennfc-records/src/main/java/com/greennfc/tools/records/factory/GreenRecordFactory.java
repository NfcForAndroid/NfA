package com.greennfc.tools.records.factory;

import com.greennfc.tools.records.base.AbstractGreenRecordBaseFactory;
import com.greennfc.tools.records.base.EmptyRecord;
import com.greennfc.tools.records.ndef.AbstractGreenRecordNdefFacory;
import com.greennfc.tools.records.ndef.ext.AbstractGreenRecordExtFactory;
import com.greennfc.tools.records.ndef.wkt.AbstractGreenRecordWktFactory;

public final class GreenRecordFactory {

	private static GreenRecordFactory instance;

	public static final EmptyRecord EMPTY_RECORD = baseFactory().emptyRecord();

	private static final synchronized GreenRecordFactory getInstance() {
		if (instance == null) {
			instance = new GreenRecordFactory();
		}
		return instance;
	}

	private GreenRecordBaseFactory baseFactory;
	private GreenRecordExtFactory extFactory;
	private GreenRecordWktFactory wktFactory;
	private GreenRecordNdefFactory ndefFactory;

	private synchronized GreenRecordBaseFactory getBaseFactory() {
		if (baseFactory == null) {
			baseFactory = new GreenRecordBaseFactory();
		}
		return baseFactory;
	}

	private synchronized GreenRecordExtFactory getExtFactory() {
		if (extFactory == null) {
			extFactory = new GreenRecordExtFactory();
		}
		return extFactory;
	}

	private synchronized GreenRecordWktFactory getWktFactory() {
		if (wktFactory == null) {
			wktFactory = new GreenRecordWktFactory();
		}
		return wktFactory;
	}

	private synchronized GreenRecordNdefFactory getNdefFactory() {
		if (ndefFactory == null) {
			ndefFactory = new GreenRecordNdefFactory();
		}
		return ndefFactory;
	}

	public static IGreenRecordBaseFactory baseFactory() {
		return GreenRecordFactory.getInstance().getBaseFactory();
	}

	public static IGreenRecordNdefFactory ndefFactory() {
		return GreenRecordFactory.getInstance().getNdefFactory();
	}

	public static IGreenRecordWktFactory wellKnowTypeFactory() {
		return GreenRecordFactory.getInstance().getWktFactory();
	}

	public static IGreenRecordExtFactory externalFactory() {
		return GreenRecordFactory.getInstance().getExtFactory();
	}

	private static class GreenRecordBaseFactory extends AbstractGreenRecordBaseFactory {
	}

	private static class GreenRecordExtFactory extends AbstractGreenRecordExtFactory {
	}

	private static class GreenRecordWktFactory extends AbstractGreenRecordWktFactory {
	}

	private static class GreenRecordNdefFactory extends AbstractGreenRecordNdefFacory {
	}

}
