package com.nfa.tools.exception;

import com.nfa.tools.exception.NfaRuntimeException;

public class NoNdefServiceException extends NfaRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 391313285271338936L;

	public NoNdefServiceException(String message) {
		super(message);
	}

}
