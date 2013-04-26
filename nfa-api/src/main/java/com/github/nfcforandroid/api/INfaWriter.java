package com.github.nfcforandroid.api;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

/**
 * @author jefBinomed
 * 
 * 
 *         This interface is used when you want to write datas.
 * 
 *         You should implement this interface when you want to add a new way to write a special {@link INfaRecord}
 * 
 *         A set of implementations exists in the nfa-writers module
 * 
 * @param <Record>
 *            the expected type to write
 */
public interface INfaWriter<Record extends INfaRecord> {

	/**
	 * @return <code>true</code> if the data is in init state. This is use by the library to guaranty the non recalculation of {@link #getLength()}. The best practice is to check if the inner record is <code>null</code> or not
	 */
	boolean isInit();

	/**
	 * reset the state of {@link #isInit()} to have a result that produce false. You could set the inner record to <code>null</code>
	 */
	void reset();

	/**
	 * Set the inner record with value in parameters
	 * 
	 * @param record
	 *            the record to set
	 */
	void init(Record record);

	/**
	 * @return the convert Android {@link NdefMessage} corresponding to datas
	 */
	NdefMessage getNdefMessage();

	/**
	 * @return the convert Android {@link NdefRecord} corresponding to datas
	 */
	NdefRecord getNdefRecord();

	/**
	 * @return the lenght in byte. -1 there is no record in it
	 */
	int getLength();

}
