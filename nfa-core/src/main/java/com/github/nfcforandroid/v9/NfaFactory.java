package com.github.nfcforandroid.v9;

import com.github.nfcforandroid.api.INfaManager;

/**
 * @author jefBinomed
 * 
 *         Core Factory for android 9that gives you access to a {@link INfaManager}
 * 
 */
public final class NfaFactory {

	private static NfaFactory instance;

	private NfaManagerV9 nfaManager;

	/**
	 * A singleton instance of the {@link INfaManager} manager in version 9
	 */
	public static final INfaManager NFA_MANAGER = getManager();

	private NfaFactory() {
		nfaManager = new NfaManagerV9();
	}

	private NfaManagerV9 getNfaManager() {
		return nfaManager;
	}

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
