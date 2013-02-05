package com.greennfc.tools.api.beans;

import android.content.Intent;

import com.greennfc.tools.api.IGreenIntentRecieve;
import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.api.IGreenRecord;

public final class GreenRecieveBean<Record extends IGreenRecord> {

	private Intent intent;
	private IGreenIntentRecieve<Record> greenIntentRecieve;
	private IGreenParser greenParser;

	private GreenRecieveBean() {
	}

	public Intent getIntent() {
		return intent;
	}

	public IGreenIntentRecieve<Record> getGreenIntentRecieve() {
		return greenIntentRecieve;
	}

	public IGreenParser getGreenParser() {
		return greenParser;
	}

	public static <Record extends IGreenRecord> GreenRecieveBeanBuilder<Record> recieveBeanConfigure() {
		return new GreenRecieveBeanBuilder<Record>();
	}

	public static class GreenRecieveBeanBuilder<Record extends IGreenRecord> {

		private GreenRecieveBean<Record> bean;

		private GreenRecieveBeanBuilder() {
			bean = new GreenRecieveBean<Record>();
		}

		public GreenRecieveBeanBuilder<Record> intent(final Intent intent) {
			bean.intent = intent;
			return this;
		}

		public GreenRecieveBeanBuilder<Record> intentRecieve(final IGreenIntentRecieve<Record> intentRecieve) {
			bean.greenIntentRecieve = intentRecieve;
			return this;
		}

		public GreenRecieveBeanBuilder<Record> parser(final IGreenParser parser) {
			bean.greenParser = parser;
			return this;
		}

		public GreenRecieveBean<Record> build() {
			assert bean.intent != null : "You don't have put any intent ! ";
			assert bean.greenIntentRecieve != null : "You don't have put any IGreenIntentRecieve ! ";
			assert bean.greenParser != null : "You don't have put any IGreenParser ! ";
			return bean;
		}

	}

}
