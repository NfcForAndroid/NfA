package com.nfa.tools.filters.factory;

import com.nfa.tools.api.INfaIntentFilter;

public interface INfaFilterWktFactory {

	INfaIntentFilter textFilter();

	INfaIntentFilter uriFilter();

}
