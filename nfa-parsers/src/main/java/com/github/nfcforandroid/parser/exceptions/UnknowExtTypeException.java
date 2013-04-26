package com.github.nfcforandroid.parser.exceptions;

import com.github.nfcforandroid.exception.NfaRuntimeException;

/**
 * @author jefBinomed
 * 
 *         Exception trown when an ext type was not interpret
 */
public class UnknowExtTypeException extends NfaRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -99373349540799378L;

	/**
	 * @param message
	 */
	public UnknowExtTypeException(String message) {
		super(message);
	}

}
