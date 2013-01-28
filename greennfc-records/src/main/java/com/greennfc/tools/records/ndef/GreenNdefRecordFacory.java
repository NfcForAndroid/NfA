package com.greennfc.tools.records.ndef;

public final class GreenNdefRecordFacory {

	private static GreenNdefRecordFacory instance;

	public static final synchronized GreenNdefRecordFacory getInstance() {
		if (instance == null) {
			instance = new GreenNdefRecordFacory();
		}
		return instance;
	}

}
