package com.github.nfcforandroid.api;

import java.util.List;

import android.nfc.NdefMessage;

/**
 * @author jefBinomed
 * 
 *         Interface that contains a list of {@link INfaRecord}
 * 
 *         Could be comparable to {@link NdefMessage}
 * 
 *         A default implementation could be found in the nfa-core module.
 * 
 */
public interface INfaMessage {

	/**
	 * @return the list of records containe in the message. An empty list else.
	 */
	List<INfaRecord> recordList();

}
