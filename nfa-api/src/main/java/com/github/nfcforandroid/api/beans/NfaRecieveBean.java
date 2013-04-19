package com.github.nfcforandroid.api.beans;

import android.content.Intent;

import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.api.client.INfaIntentRecieveMessage;
import com.github.nfcforandroid.api.client.INfaIntentRecieveRecord;

/**
 * @author jefBinomed
 * 
 *         Configuration bean that gives mandatory information about how to read data on a tag : <li>
 *         <ul>
 *         A {@link Intent} for the information transfer by the system
 *         </ul>
 *         <ul>
 *         A {@link INfaIntentRecieveMessage} for the data if it is a message that is expected
 *         </ul>
 *         <ul>
 *         A {@link INfaIntentRecieveRecord} for the data if it is a record that is expected
 *         </ul>
 *         <ul>
 *         A {@link INfaParser} for the mecanism to parse the datas
 *         </ul>
 *         <ul>
 *         A boolean that indicates if we want to include in the final message the potential AndroidApplicatioNRecord found.
 *         </ul>
 *         </li>
 * 
 *         To create a such instance, you have to use the builder
 * 
 *         <code>
 *          NfaRecieveBean.recieveBeanConfigure().intent(theIntent).intentRecieveMessage(callBackMessage).parser(YourParser).build();
 *         </code>
 * 
 * @param <Record>
 *            the record to write
 */
public final class NfaRecieveBean<Record extends INfaRecord> {

	private Intent intent;
	private INfaIntentRecieveRecord<Record> nfaIntentRecieveRecord;
	private INfaIntentRecieveMessage nfaIntentRecieveMessage;
	private INfaParser nfaParser;
	private boolean avoidAndroidApplicationRecord;

	private NfaRecieveBean() {
	}

	/**
	 * @return the intent at the origini of the action
	 */
	public Intent getIntent() {
		return intent;
	}

	/**
	 * @return the record callback interface
	 */
	public INfaIntentRecieveRecord<Record> getNfaIntentRecieveRecord() {
		return nfaIntentRecieveRecord;
	}

	/**
	 * @return The message callback interface
	 */
	public INfaIntentRecieveMessage getNfaIntentRecieveMessage() {
		return nfaIntentRecieveMessage;
	}

	/**
	 * @return the parser to use for the conversion
	 */
	public INfaParser getNfaParser() {
		return nfaParser;
	}

	/**
	 * @return <code>true</code> if we don't want to return an AndroidApplicationRecord if there is one detected in the original message
	 */
	public boolean isAvoidAndroidApplicationRecord() {
		return avoidAndroidApplicationRecord;
	}

	/**
	 * @return a new instance of {@link NfaRecieveBeanBuilder} on each call
	 */
	public static <Record extends INfaRecord> NfaRecieveBeanBuilder<Record> recieveBeanConfigure() {
		return new NfaRecieveBeanBuilder<Record>();
	}

	/**
	 * @author jefBinomed
	 * 
	 *         Inner class for building {@link NfaRecieveBean}
	 * 
	 * @param <Record>
	 */
	public static class NfaRecieveBeanBuilder<Record extends INfaRecord> {

		private NfaRecieveBean<Record> bean;

		private NfaRecieveBeanBuilder() {
			bean = new NfaRecieveBean<Record>();
		}

		/**
		 * set the original intent
		 * 
		 * @param intent
		 *            the intent at the origin of the call
		 * @return the current instance of the builder
		 */
		public NfaRecieveBeanBuilder<Record> intent(final Intent intent) {
			bean.intent = intent;
			return this;
		}

		/**
		 * Set the callback for reading record
		 * 
		 * @param intentRecieveRecord
		 *            the callback implementation for reading record
		 * @return the current instance of the builder
		 */
		public NfaRecieveBeanBuilder<Record> intentRecieveRecord(final INfaIntentRecieveRecord<Record> intentRecieveRecord) {
			bean.nfaIntentRecieveRecord = intentRecieveRecord;
			return this;
		}

		/**
		 * Set the callback for reading message
		 * 
		 * @param intentRecieveMessage
		 *            the callback implementation for reading message
		 * @return the current instance of the builder
		 */
		public NfaRecieveBeanBuilder<Record> intentRecieveMessage(final INfaIntentRecieveMessage intentRecieveMessage) {
			bean.nfaIntentRecieveMessage = intentRecieveMessage;
			return this;
		}

		/**
		 * @param parser
		 * @return the current instance of the builder
		 */
		public NfaRecieveBeanBuilder<Record> parser(final INfaParser parser) {
			bean.nfaParser = parser;
			return this;
		}

		/**
		 * @param avoid
		 *            <code>true</code> if we don't want to return an AndroidApplicationRecord if there is one detected in the original message. If not called, the value will be set to false
		 * @return the current instance of the builder
		 */
		public NfaRecieveBeanBuilder<Record> avoidAndroidApplicationRecord(final boolean avoid) {
			bean.avoidAndroidApplicationRecord = avoid;
			return this;
		}

		/**
		 * Validate the bean by checking that the intent is not null, the parser is not null and that there only one callback set.
		 * 
		 * @return the instance of the bean to give to the librairy for reading the datas
		 * @throws AssertionError
		 *             if the intent is not set, if the parser is not set, if there is no callback or if there is two callback defined
		 */
		public NfaRecieveBean<Record> build() {
			assert bean.intent != null : "You don't have put any intent ! ";
			assert bean.nfaParser != null : "You don't have put any INfaParser ! ";

			assert (bean.nfaIntentRecieveMessage != null || bean.nfaIntentRecieveRecord != null) : "You have to choose at least one INfaIntentRecieveRecord or INfaIntentRecieveMessage";
			assert !(bean.nfaIntentRecieveMessage != null && bean.nfaIntentRecieveRecord != null) : "You cannot specify both receptions, you to choose if you catch a single record or a message";
			return bean;
		}

	}

}
