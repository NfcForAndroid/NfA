package com.nfa.tools.filters.factory;

import com.nfa.tools.api.INfaIntentFilter;

public interface INfaFilterExtFactory {

	INfaIntentFilter externalNdefFilter(String path);

	INfaIntentFilter textExternalNdefFilter(String path);

}
