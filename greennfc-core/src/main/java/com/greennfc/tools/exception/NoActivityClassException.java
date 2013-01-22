package com.greennfc.tools.exception;

public class NoActivityClassException extends RuntimeException {

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
