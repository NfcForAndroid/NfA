package com.nfa.tools.api.client;

/**
 * @author jefBinomed Interface which defines the methods to use for callback management when writing tags
 * 
 *         This interface is to use when you want to manage a callback when you write on nfc tags.
 * 
 * @see INfaBeam
 * 
 */
public interface INfaIntentWrite {

	/**
	 * Callback method which gives you the state of the write.
	 * 
	 * @param ok
	 *            : <code>true</code> if the write was well done, <code>false</code> else.
	 * @param error
	 *            : the error corresponding to problem of write. Only valuate when the param ok is set to <code>false</code>
	 */
	void messageWrite(boolean ok, Exception error);

}
