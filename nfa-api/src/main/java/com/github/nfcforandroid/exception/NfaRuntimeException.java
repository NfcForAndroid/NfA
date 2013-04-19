package com.github.nfcforandroid.exception;

/**
 * @author jefBinomed
 * 
 *         Runtime exception for Nfa project
 * 
 */
public class NfaRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -317283007209543484L;

	public NfaRuntimeException() {
		super();
	}

	public NfaRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NfaRuntimeException(String arg0) {
		super(arg0);
	}

	public NfaRuntimeException(Throwable arg0) {
		super(arg0);
	}

}
