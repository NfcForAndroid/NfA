package com.greennfc.tools.v9;

import com.greennfc.tools.api.IGreenManager;

/**
 * @author jefBinomed
 * 
 */
public final class GreenNfcFactory {

	private static GreenNfcFactory instance;

	private GreenManagerV9 greenManager;

	public static final IGreenManager GREEN_NFC_MANAGER = getManager();

	private GreenNfcFactory() {
		greenManager = new GreenManagerV9();
	}

	public GreenManagerV9 getGreenManager() {
		return greenManager;
	}

	private static final synchronized GreenNfcFactory getInstance() {
		if (instance == null) {
			instance = new GreenNfcFactory();
		}
		return instance;
	}

	public static IGreenManager getManager() {
		return getInstance().getGreenManager();
	}

}
