package com.greennfc.tools.filters.ndef.ext;

import com.greennfc.tools.api.IGreenIntentFilter;

public class GreenFilterNdefFactory {

	private static GreenFilterNdefFactory instance;

	private static synchronized GreenFilterNdefFactory getInstance() {
		if (instance == null) {
			instance = new GreenFilterNdefFactory();
		}
		return instance;
	}

	public static IGreenIntentFilter externalNdefFilter(String path) {
		return new ExternalNdefFilter(path);
	}

	public static IGreenIntentFilter textExternalNdefFilter(String path) {
		return new TextExternalNdefFilter(path);
	}

}
