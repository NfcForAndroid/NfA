package com.greennfc.tools;

import com.greennfc.tools.api.IGreenManager;

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

	public static IGreenManager newManager() {
		return new GreenManager();
	}

}
