package com.greennfc.tools.records.ndef;

import com.greennfc.tools.records.factory.IGreenRecordNdefFactory;

public abstract class AbstractGreenRecordNdefFacory implements IGreenRecordNdefFactory {

	protected AbstractGreenRecordNdefFacory() {
	}

	public MimeTypeRecord mimeRecordInstance(String mimeType, byte[] datas) {
		return new MimeTypeRecord(mimeType, datas);
	}

}
