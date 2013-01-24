package com.greennfc.tools.exception;

public abstract class GreenNfcRuntimeException extends RuntimeException {

	public GreenNfcRuntimeException() {
		super();
	}

	public GreenNfcRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public GreenNfcRuntimeException(String arg0) {
		super(arg0);
	}

	public GreenNfcRuntimeException(Throwable arg0) {
		super(arg0);
	}

}
