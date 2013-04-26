package com.github.nfcforandroid.exception;

/**
 * @author jefBinomed
 * 
 *         Write exception, this exception will be thrown during the conversion of nfa messages to android messages
 * 
 */
public class WriteException extends NfaRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8796476642204182101L;

	public WriteException() {
		super();
	}

	public WriteException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public WriteException(String arg0) {
		super(arg0);
	}

	public WriteException(Throwable arg0) {
		super(arg0);
	}

}
