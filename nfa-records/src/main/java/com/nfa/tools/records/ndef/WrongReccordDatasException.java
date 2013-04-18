package com.nfa.tools.records.ndef;

import com.nfa.tools.exception.NfaRuntimeException;

/**
 * @author jefBinomed Exception that is thrown when the datas of a record is not corresponding to the datas expected
 */
public class WrongReccordDatasException extends NfaRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3471462864729570563L;

	/**
	 * @param text
	 *            the source of the exception
	 */
	public WrongReccordDatasException(String text) {
		super(text);
	}

}
