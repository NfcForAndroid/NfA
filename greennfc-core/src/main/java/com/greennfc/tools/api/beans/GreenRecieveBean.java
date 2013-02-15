package com.greennfc.tools.api.beans;

import android.content.Intent;

import com.greennfc.tools.api.IGreenIntentRecieveMessage;
import com.greennfc.tools.api.IGreenIntentRecieveRecord;
import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.api.IGreenRecord;

public final class GreenRecieveBean<Record extends IGreenRecord> {

	private Intent intent;
	private IGreenIntentRecieveRecord<Record> greenIntentRecieveRecord;
	private IGreenIntentRecieveMessage greenIntentRecieveMessage;
	private IGreenParser greenParser;

	private GreenRecieveBean() {
	}

	public Intent getIntent() {
		return intent;
	}

	public IGreenIntentRecieveRecord<Record> getGreenIntentRecieveRecord() {
		return greenIntentRecieveRecord;
	}

	public IGreenIntentRecieveMessage getGreenIntentRecieveMessage() {
		return greenIntentRecieveMessage;
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

		public GreenRecieveBeanBuilder<Record> intentRecieveRecord(final IGreenIntentRecieveRecord<Record> intentRecieveRecord) {
			bean.greenIntentRecieveRecord = intentRecieveRecord;
			return this;
		}

		public GreenRecieveBeanBuilder<Record> intentRecieveMessage(final IGreenIntentRecieveMessage intentRecieveMessage) {
			bean.greenIntentRecieveMessage = intentRecieveMessage;
			return this;
		}

		public GreenRecieveBeanBuilder<Record> parser(final IGreenParser parser) {
			bean.greenParser = parser;
			return this;
		}

		public GreenRecieveBean<Record> build() {
			assert bean.intent != null : "You don't have put any intent ! ";
			assert bean.greenParser != null : "You don't have put any IGreenParser ! ";

			assert (bean.greenIntentRecieveMessage != null || bean.greenIntentRecieveRecord != null) : "You have to choose at least one IGreenIntentRecieveRecord or IGreenIntentRecieveMessage";
			assert !(bean.greenIntentRecieveMessage != null && bean.greenIntentRecieveRecord != null) : "You cannot specify both receptions, you to choose if you catch a single record or a message";
			return bean;
		}

	}

}
