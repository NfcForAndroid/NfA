package com.github.nfcforandroid.v14;

import com.github.nfcforandroid.api.INfaManager;

/**
 * @author jefBinomed
 * 
 *         Core Factory for android 14 or higher that gives you access to a {@link INfaManager}
 */
public final class NfaFactory {

	private static NfaFactory instance;

	private NfaManagerV14 nfaManager;

	/**
	 * A singleton instance of the {@link INfaManager} manager in version 14 or higher
	 */
	public static final INfaManager NFA_MANAGER = getManager();

	private NfaFactory() {
		nfaManager = new NfaManagerV14();
	}

	/**
	 * @return an instance of {@link NfaManagerV14}
	 */
	private NfaManagerV14 getNfaManager() {
		return nfaManager;
	}

	/**
	 * @return a singleton instance of the curent factory
	 */
	private static final synchronized NfaFactory getInstance() {
		if (instance == null) {
			instance = new NfaFactory();
		}
		return instance;
	}

	/**
	 * @return A singleton instance of the {@link INfaManager} manager in version 14 or higher
	 */
	public static INfaManager getManager() {
		return getInstance().getNfaManager();
	}

}
