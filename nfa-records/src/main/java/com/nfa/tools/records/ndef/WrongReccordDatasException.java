package com.nfa.tools.records.ndef;

import com.nfa.tools.exception.NfaRuntimeException;

public class WrongReccordDatasException extends NfaRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3471462864729570563L;

	public WrongReccordDatasException(String text) {
		super(text);
	}

}
