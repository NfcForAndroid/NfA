package com.greennfc.tools.records.ndef;

import com.greennfc.tools.exception.GreenNfcRuntimeException;

public class WrongReccordDatasException extends GreenNfcRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3471462864729570563L;

	public WrongReccordDatasException(String text) {
		super(text);
	}

}
