package com.nfa.tools.api.client;

import android.nfc.NdefMessage;

import com.nfa.tools.api.INfaMessage;

/**
 * @author jefBinomed
 * 
 *         Inteface that defines the method to use when you want to read an {@link NdefMessage}
 * 
 *         You should use this interface when you want to read {@link NdefMessage}
 * 
 * @see INfaIntentRecieveRecord
 * 
 */
public interface INfaIntentRecieveMessage {

	/**
	 * This method is called when a message is recieved by the android framework. The message is passed in parameters.
	 * 
	 * @param message
	 *            the message to deliver. Couldn't be <code>null</code>
	 */
	void recieveMessage(INfaMessage message);

}
