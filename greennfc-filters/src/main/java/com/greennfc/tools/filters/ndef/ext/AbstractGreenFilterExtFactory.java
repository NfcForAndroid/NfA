package com.greennfc.tools.filters.ndef.ext;

import com.greennfc.tools.api.IGreenIntentFilter;
import com.greennfc.tools.filters.factory.IGreenFilterExtFactory;

public abstract class AbstractGreenFilterExtFactory implements IGreenFilterExtFactory {

	protected AbstractGreenFilterExtFactory() {
	}

	public IGreenIntentFilter externalNdefFilter(String path) {
		return new ExternalNdefFilter(path);
	}

	public IGreenIntentFilter textExternalNdefFilter(String path) {
		return new TextExternalNdefFilter(path);
	}

}
