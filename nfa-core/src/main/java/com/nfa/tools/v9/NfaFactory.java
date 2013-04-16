package com.nfa.tools.v9;

import com.nfa.tools.api.INfaManager;

/**
 * @author jefBinomed
 * 
 */
public final class NfaFactory {

	private static NfaFactory instance;

	private NfaManagerV9 greenManager;

	public static final INfaManager GREEN_NFC_MANAGER = getManager();

	private NfaFactory() {
		greenManager = new NfaManagerV9();
	}

	public NfaManagerV9 getGreenManager() {
		return greenManager;
	}

	private static final synchronized NfaFactory getInstance() {
		if (instance == null) {
			instance = new NfaFactory();
		}
		return instance;
	}

	public static INfaManager getManager() {
		return getInstance().getGreenManager();
	}

}
