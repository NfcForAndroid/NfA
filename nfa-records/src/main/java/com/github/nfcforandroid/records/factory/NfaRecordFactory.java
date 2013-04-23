package com.github.nfcforandroid.records.factory;

import com.github.nfcforandroid.records.base.AbstractNfaRecordBaseFactory;
import com.github.nfcforandroid.records.base.EmptyRecord;
import com.github.nfcforandroid.records.ndef.AbstractNfaRecordNdefFacory;
import com.github.nfcforandroid.records.ndef.ext.AbstractNfaRecordExtFactory;
import com.github.nfcforandroid.records.ndef.wkt.AbstractNfaRecordWktFactory;

public final class NfaRecordFactory {

	private static NfaRecordFactory instance;

	public static final EmptyRecord EMPTY_RECORD = baseFactory().emptyRecord();

	private static final synchronized NfaRecordFactory getInstance() {
		if (instance == null) {
			instance = new NfaRecordFactory();
		}
		return instance;
	}

	private NfaRecordBaseFactory baseFactory;
	private NfaRecordExtFactory extFactory;
	private NfaRecordWktFactory wktFactory;
	private NfaRecordNdefFactory ndefFactory;

	private synchronized NfaRecordBaseFactory getBaseFactory() {
		if (baseFactory == null) {
			baseFactory = new NfaRecordBaseFactory();
		}
		return baseFactory;
	}

	private synchronized NfaRecordExtFactory getExtFactory() {
		if (extFactory == null) {
			extFactory = new NfaRecordExtFactory();
		}
		return extFactory;
	}

	private synchronized NfaRecordWktFactory getWktFactory() {
		if (wktFactory == null) {
			wktFactory = new NfaRecordWktFactory();
		}
		return wktFactory;
	}

	private synchronized NfaRecordNdefFactory getNdefFactory() {
		if (ndefFactory == null) {
			ndefFactory = new NfaRecordNdefFactory();
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

	private static class NfaRecordBaseFactory extends AbstractNfaRecordBaseFactory {
	}

	private static class NfaRecordExtFactory extends AbstractNfaRecordExtFactory {
	}

	private static class NfaRecordWktFactory extends AbstractNfaRecordWktFactory {
	}

	private static class NfaRecordNdefFactory extends AbstractNfaRecordNdefFacory {
	}

}
