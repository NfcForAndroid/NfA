package com.greennfc.tools.api.beans;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;

public final class GreenWriteBean<Record extends IGreenRecord> {

	private IGreenWriter<Record> greenWriter;
	private Record greenRecord;
	private boolean forceReinit = true;

	private GreenWriteBean() {
	}

	public IGreenWriter<Record> getGreenWriter() {
		return greenWriter;
	}

	public Record getGreenRecord() {
		return greenRecord;
	}

	public boolean isForceReinit() {
		return forceReinit;
	}

	public static <Record extends IGreenRecord> GreenWriteBeanBuilder<Record> writeBeanConfigure() {
		return new GreenWriteBeanBuilder<Record>();
	}

	public static class GreenWriteBeanBuilder<Record extends IGreenRecord> {

		private GreenWriteBean<Record> bean;

		private GreenWriteBeanBuilder() {
			bean = new GreenWriteBean<Record>();
		}

		public GreenWriteBeanBuilder<Record> writer(final IGreenWriter<Record> writer) {
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

		public GreenWriteBean<Record> build() {
			assert bean.greenWriter != null : "You don't have put any IGreenWriter ! ";
			assert bean.greenWriter.isInit() || bean.greenRecord != null : "You don't have put any IGreenRecord ! ";

			return bean;
		}

	}

}
