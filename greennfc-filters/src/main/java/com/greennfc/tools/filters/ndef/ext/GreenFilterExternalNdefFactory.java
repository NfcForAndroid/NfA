package com.greennfc.tools.filters.ndef.ext;

import com.greennfc.tools.api.IGreenIntentFilter;

public class GreenFilterExternalNdefFactory {

	private static GreenFilterExternalNdefFactory instance;

	private GreenFilterExternalNdefFactory() {

	}

	public static synchronized GreenFilterExternalNdefFactory getInstance() {
		if (instance == null) {
			instance = new GreenFilterExternalNdefFactory();
		}
		return instance;
	}

	public IGreenIntentFilter externalNdefFilter(String path) {
		return new ExternalNdefFilter(path);
	}

	public IGreenIntentFilter textExternalNdefFilter(String path) {
		return new TextExternalNdefFilter(path);
	}

}
