package com.nfa.tools.exception;

/**
 * @author jefBinomed Exception thrown if an error occured during writing tag or communicating with beam
 */
public class NoNdefServiceException extends NfaRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 391313285271338936L;

	public NoNdefServiceException(String message) {
		super(message);
	}

}
