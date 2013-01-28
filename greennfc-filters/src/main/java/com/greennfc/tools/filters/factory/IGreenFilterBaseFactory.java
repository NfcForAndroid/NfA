package com.greennfc.tools.filters.factory;

import com.greennfc.tools.api.IGreenIntentFilter;

public interface IGreenFilterBaseFactory {

	IGreenIntentFilter ndefFilter();

	IGreenIntentFilter tagFilter();

	IGreenIntentFilter techFilter();

}
