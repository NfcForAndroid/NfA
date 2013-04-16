package com.nfa.tools.filters.ndef.ext;

import com.nfa.tools.filters.base.NdefFilter;
import com.nfa.tools.filters.cst.NfaFiltersCst;

public final class ExternalNdefFilter extends NdefFilter {

	private final String path;

	protected ExternalNdefFilter(String path) {
		this.path = path;
	}

	@Override
	public String getDataAuthorityHost() {
		return NfaFiltersCst.AUTHORITY_NDEF;
	}

	@Override
	public String getDataScheme() {
		return NfaFiltersCst.SCHEME_NDEF;
	}

	@Override
	public String getDataPath() {
		return path;
	}

}