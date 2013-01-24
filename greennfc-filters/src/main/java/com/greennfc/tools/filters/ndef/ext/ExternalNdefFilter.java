package com.greennfc.tools.filters.ndef.ext;

import com.greennfc.tools.filters.GreenFiltersCst;
import com.greennfc.tools.filters.ndef.NdefFilter;

public final class ExternalNdefFilter extends NdefFilter {

	private final String path;

	protected ExternalNdefFilter(String path) {
		this.path = path;
	}

	@Override
	public String getDataAuthorityHost() {
		return GreenFiltersCst.AUTHORITY_NDEF;
	}

	@Override
	public String getDataScheme() {
		return GreenFiltersCst.SCHEME_NDEF;
	}

	@Override
	public String getDataPath() {
		return path;
	}

}
