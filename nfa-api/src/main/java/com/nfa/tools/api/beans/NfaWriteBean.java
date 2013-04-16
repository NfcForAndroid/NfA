package com.nfa.tools.api.beans;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.INfaWriter;

public final class NfaWriteBean<Record extends INfaRecord> {

	private INfaWriter<Record> greenWriter;
	private Record greenRecord;
	private boolean forceReinit = true;

	private NfaWriteBean() {
	}

	public INfaWriter<Record> getGreenWriter() {
		return greenWriter;
	}

	public Record getGreenRecord() {
		return greenRecord;
	}

	public boolean isForceReinit() {
		return forceReinit;
	}

	public static <Record extends INfaRecord> GreenWriteBeanBuilder<Record> writeBeanConfigure() {
		return new GreenWriteBeanBuilder<Record>();
	}

	public static class GreenWriteBeanBuilder<Record extends INfaRecord> {

		private NfaWriteBean<Record> bean;

		private GreenWriteBeanBuilder() {
			bean = new NfaWriteBean<Record>();
		}

		public GreenWriteBeanBuilder<Record> writer(final INfaWriter<Record> writer) {
			bean.greenWriter = writer;
			return this;
		}

		public GreenWriteBeanBuilder<Record> record(final Record record) {
			bean.greenRecord = record;
			return this;
		}

		public GreenWriteBeanBuilder<Record> forceReinit(final boolean forceReinit) {
			bean.forceReinit = forceReinit;
			return this;
		}

		public NfaWriteBean<Record> build() {
			assert bean.greenWriter != null : "You don't have put any IGreenWriter ! ";
			assert bean.greenWriter.isInit() || bean.greenRecord != null : "You don't have put any IGreenRecord ! ";

			return bean;
		}

	}

}
