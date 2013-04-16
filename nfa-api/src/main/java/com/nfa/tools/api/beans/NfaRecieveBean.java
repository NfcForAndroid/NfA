package com.nfa.tools.api.beans;

import android.content.Intent;

import com.nfa.tools.api.INfaIntentRecieveMessage;
import com.nfa.tools.api.INfaIntentRecieveRecord;
import com.nfa.tools.api.INfaParser;
import com.nfa.tools.api.INfaRecord;

public final class NfaRecieveBean<Record extends INfaRecord> {

	private Intent intent;
	private INfaIntentRecieveRecord<Record> greenIntentRecieveRecord;
	private INfaIntentRecieveMessage greenIntentRecieveMessage;
	private INfaParser greenParser;
	private boolean avoidAndroidApplicationRecord;

	private NfaRecieveBean() {
	}

	public Intent getIntent() {
		return intent;
	}

	public INfaIntentRecieveRecord<Record> getGreenIntentRecieveRecord() {
		return greenIntentRecieveRecord;
	}

	public INfaIntentRecieveMessage getGreenIntentRecieveMessage() {
		return greenIntentRecieveMessage;
	}

	public INfaParser getGreenParser() {
		return greenParser;
	}

	public boolean isAvoidAndroidApplicationRecord() {
		return avoidAndroidApplicationRecord;
	}

	public static <Record extends INfaRecord> GreenRecieveBeanBuilder<Record> recieveBeanConfigure() {
		return new GreenRecieveBeanBuilder<Record>();
	}

	public static class GreenRecieveBeanBuilder<Record extends INfaRecord> {

		private NfaRecieveBean<Record> bean;

		private GreenRecieveBeanBuilder() {
			bean = new NfaRecieveBean<Record>();
		}

		public GreenRecieveBeanBuilder<Record> intent(final Intent intent) {
			bean.intent = intent;
			return this;
		}

		public GreenRecieveBeanBuilder<Record> intentRecieveRecord(final INfaIntentRecieveRecord<Record> intentRecieveRecord) {
			bean.greenIntentRecieveRecord = intentRecieveRecord;
			return this;
		}

		public GreenRecieveBeanBuilder<Record> intentRecieveMessage(final INfaIntentRecieveMessage intentRecieveMessage) {
			bean.greenIntentRecieveMessage = intentRecieveMessage;
			return this;
		}

		public GreenRecieveBeanBuilder<Record> parser(final INfaParser parser) {
			bean.greenParser = parser;
			return this;
		}

		public GreenRecieveBeanBuilder<Record> avoidAndroidApplicationRecord(final boolean avoid) {
			bean.avoidAndroidApplicationRecord = avoid;
			return this;
		}

		public NfaRecieveBean<Record> build() {
			assert bean.intent != null : "You don't have put any intent ! ";
			assert bean.greenParser != null : "You don't have put any IGreenParser ! ";

			assert (bean.greenIntentRecieveMessage != null || bean.greenIntentRecieveRecord != null) : "You have to choose at least one IGreenIntentRecieveRecord or IGreenIntentRecieveMessage";
			assert !(bean.greenIntentRecieveMessage != null && bean.greenIntentRecieveRecord != null) : "You cannot specify both receptions, you to choose if you catch a single record or a message";
			return bean;
		}

	}

}
