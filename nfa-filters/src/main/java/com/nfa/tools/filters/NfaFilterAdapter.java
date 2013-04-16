package com.nfa.tools.filters;

import com.nfa.tools.api.INfaIntentFilter;

public abstract class NfaFilterAdapter implements INfaIntentFilter {

	public String getDataType() {
		return null;
	}

	public String getAction() {
		return null;
	}

	public String getDataScheme() {
		return null;
	}

	public String getDataAuthorityPort() {
		return null;
	}

	public String getDataAuthorityHost() {
		return null;
	}

	public String getDataPath() {
		return null;
	}

}
