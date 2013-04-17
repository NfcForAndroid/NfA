package com.nfa.tools.api.beans;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.INfaWriter;

/**
 * @author jefBinomed
 * 
 *         Configuration bean that gives mandatory information about how to write data on a tag : <li>
 *         <ul>
 *         A {@link INfaWriter} for the conversion
 *         </ul>
 *         <ul>
 *         A {@link INfaRecord} for the data
 *         </ul>
 *         </li>
 * 
 *         To create a such instance, you have to use the builder
 * 
 *         <code>
 *          NfaWriteBean.writeBeanConfigure().writer(YourWriter).record(YourRecord).build();
 *         </code>
 * 
 * @param <Record>
 *            the record to write
 */
public final class NfaWriteBean<Record extends INfaRecord> {

	private INfaWriter<Record> nfaWriter;
	private Record nfaRecord;
	private boolean forceReinit = true;

	private NfaWriteBean() {
	}

	/**
	 * @return the writer to use to convert data. Could not be <code>null</code>
	 */
	public INfaWriter<Record> getNfaWriter() {
		return nfaWriter;
	}

	/**
	 * @return the data to write. Could not be <code>null</code>
	 */
	public Record getNfaRecord() {
		return nfaRecord;
	}

	/**
	 * @return <code>true</code> if we have to reset the record after the write. <code>false</code> else. The default value returns <code>true</code>.
	 */
	public boolean isForceReinit() {
		return forceReinit;
	}

	/**
	 * @return a new instance of {@link NfaWriteBeanBuilder} on each call
	 */
	public static <Record extends INfaRecord> NfaWriteBeanBuilder<Record> writeBeanConfigure() {
		return new NfaWriteBeanBuilder<Record>();
	}

	/**
	 * @author jefBinomed
	 * 
	 *         Inner class for building {@link NfaWriteBean}
	 * 
	 * @param <Record>
	 */
	public static class NfaWriteBeanBuilder<Record extends INfaRecord> {

		private NfaWriteBean<Record> bean;

		private NfaWriteBeanBuilder() {
			bean = new NfaWriteBean<Record>();
		}

		/**
		 * set the final writer
		 * 
		 * @param writer
		 *            the writer to use
		 * @return the current instance of the builder
		 */
		public NfaWriteBeanBuilder<Record> writer(final INfaWriter<Record> writer) {
			bean.nfaWriter = writer;
			return this;
		}

		/**
		 * set the final record
		 * 
		 * @param record
		 *            the record to use
		 * @return the current instance of the builder
		 */
		public NfaWriteBeanBuilder<Record> record(final Record record) {
			bean.nfaRecord = record;
			return this;
		}

		/**
		 * @param forceReinit
		 *            <code>true</code> if we have to reset the record after the write. <code>false</code> else. If not called the value <code>true</code> is set.
		 * @return
		 */
		public NfaWriteBeanBuilder<Record> forceReinit(final boolean forceReinit) {
			bean.forceReinit = forceReinit;
			return this;
		}

		/**
		 * Validate the bean by checking that the writer is set and by checking that there is a record set on the bean or directly on the writer
		 * 
		 * @return the instance of the bean to give to the librairy for writing the datas
		 * @throws AssertionError
		 *             if the writer is not set or if the record is not set
		 */
		public NfaWriteBean<Record> build() {
			assert bean.nfaWriter != null : "You don't have put any INfaWriter ! ";
			assert bean.nfaWriter.isInit() || bean.nfaRecord != null : "You don't have put any INfaRecord ! ";

			return bean;
		}

	}

}
