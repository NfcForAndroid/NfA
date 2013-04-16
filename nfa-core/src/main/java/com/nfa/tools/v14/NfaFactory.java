package com.nfa.tools.v14;

import com.nfa.tools.api.INfaManager;

/**
 * @author jefBinomed
 * 
 */
public final class NfaFactory {

	private static NfaFactory instance;

	private NfaManagerV14 greenManager;

	public static final INfaManager GREEN_NFC_MANAGER = getManager();

	private NfaFactory() {
		greenManager = new NfaManagerV14();
	}

	public NfaManagerV14 getGreenManager() {
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
