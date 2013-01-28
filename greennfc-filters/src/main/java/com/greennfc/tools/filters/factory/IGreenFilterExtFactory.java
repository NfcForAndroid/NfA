package com.greennfc.tools.filters.factory;

import com.greennfc.tools.api.IGreenIntentFilter;

public interface IGreenFilterExtFactory {

	IGreenIntentFilter externalNdefFilter(String path);

	IGreenIntentFilter textExternalNdefFilter(String path);

}
