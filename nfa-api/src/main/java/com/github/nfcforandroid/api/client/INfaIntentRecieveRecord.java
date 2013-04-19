package com.github.nfcforandroid.api.client;

import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaRecord;

/**
 * @author jefBinomed
 * 
 *         Inteface that defines the method to use when you want to read an {@link NdefRecord}
 * 
 *         You should use this interface when you want to read {@link NdefRecord}.
 * 
 *         /!\ If your are waiting multi records types tag, you should user {@link INfaIntentRecieveMessage} instead of this interface because you will have {@link ClassCastException} else
 * 
 * @see INfaIntentRecieveMessage
 * 
 * @param <Record>
 *            the type of record expected
 */
public interface INfaIntentRecieveRecord<Record extends INfaRecord> {

	/**
	 * This method is called when a record is recieved by the android framework. The record is passed in parameters.
	 * 
	 * If an NdefMessage is detect with multiple record in it, you will enter in the method for each record of the message.
	 * 
	 * @param record
	 *            the message to deliver. Couldn't be <code>null</code>
	 */
	void recieveRecord(Record record);

}
