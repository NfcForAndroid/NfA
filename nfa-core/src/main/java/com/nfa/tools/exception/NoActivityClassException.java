package com.nfa.tools.exception;

import com.nfa.tools.exception.NfaRuntimeException;

public class NoActivityClassException extends NfaRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6831208203981655753L;

	public NoActivityClassException() {
		super();
	}

	public NoActivityClassException(Class<?> clazz) {
		super("The class you use is not an Activity : " + clazz.getName());
	}

}
