package com.nfa.tools.records.factory;

import com.nfa.tools.records.base.AbstractNfaRecordBaseFactory;
import com.nfa.tools.records.base.EmptyRecord;
import com.nfa.tools.records.ndef.AbstractNfaRecordNdefFacory;
import com.nfa.tools.records.ndef.ext.AbstractNfaRecordExtFactory;
import com.nfa.tools.records.ndef.wkt.AbstractNfaRecordWktFactory;

public final class NfaRecordFactory {

	private static NfaRecordFactory instance;

	public static final EmptyRecord EMPTY_RECORD = baseFactory().emptyRecord();

	private static final synchronized NfaRecordFactory getInstance() {
		if (instance == null) {
			instance = new NfaRecordFactory();
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

	public static INfaRecordBaseFactory baseFactory() {
		return NfaRecordFactory.getInstance().getBaseFactory();
	}

	public static INfaRecordNdefFactory ndefFactory() {
		return NfaRecordFactory.getInstance().getNdefFactory();
	}

	public static INfaRecordWktFactory wellKnowTypeFactory() {
		return NfaRecordFactory.getInstance().getWktFactory();
	}

	public static INfaRecordExtFactory externalFactory() {
		return NfaRecordFactory.getInstance().getExtFactory();
	}

	private static class GreenRecordBaseFactory extends AbstractNfaRecordBaseFactory {
	}

	private static class GreenRecordExtFactory extends AbstractNfaRecordExtFactory {
	}

	private static class GreenRecordWktFactory extends AbstractNfaRecordWktFactory {
	}

	private static class GreenRecordNdefFactory extends AbstractNfaRecordNdefFacory {
	}

}
