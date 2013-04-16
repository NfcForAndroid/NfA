package com.nfa.tools.filters.ndef.ext;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.factory.INfaFilterExtFactory;

public abstract class AbstractNfaFilterExtFactory implements INfaFilterExtFactory {

	protected AbstractNfaFilterExtFactory() {
	}

	public INfaIntentFilter externalNdefFilter(String path) {
		return new ExternalNdefFilter(path);
	}

	public INfaIntentFilter textExternalNdefFilter(String path) {
		return new TextExternalNdefFilter(path);
	}

}
