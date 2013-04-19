package com.github.nfcforandroid.records.ndef;

import com.github.nfcforandroid.exception.NfaRuntimeException;

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
