package com.greennfc.tools;

import com.greennfc.tools.api.IGreenManager;
import com.greennfc.tools.api.IGreenRecord;

/**
 * @author jefBinomed
 * 
 */
public class GreenNfcFactory {

	private static GreenNfcFactory instance;

	private static final synchronized GreenNfcFactory getInstance() {
		if (instance == null) {
			instance = new GreenNfcFactory();
		}
		return instance;
	}

	public static <Record extends IGreenRecord> IGreenManager<Record> newManager() {
		return (IGreenManager<Record>) new GreenManager();
	}

}
