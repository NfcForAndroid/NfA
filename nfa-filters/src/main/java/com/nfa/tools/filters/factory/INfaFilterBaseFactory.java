package com.nfa.tools.filters.factory;

import com.nfa.tools.api.INfaIntentFilter;

public interface INfaFilterBaseFactory {

	INfaIntentFilter ndefFilter();

	INfaIntentFilter tagFilter();

	INfaIntentFilter techFilter();

}
