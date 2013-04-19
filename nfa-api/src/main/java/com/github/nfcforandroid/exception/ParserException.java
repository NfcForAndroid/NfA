package com.github.nfcforandroid.exception;

/**
 * @author jefBinomed
 * 
 *         Parser exception, this exception will be thrown during the conversion of android messages to nfa messages
 * 
 */
public class ParserException extends NfaRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5646040804490870667L;

	public ParserException(Throwable arg0) {
		super(arg0);
	}

}
