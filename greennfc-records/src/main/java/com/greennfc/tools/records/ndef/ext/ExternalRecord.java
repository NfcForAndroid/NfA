package com.greennfc.tools.records.ndef.ext;

import com.greennfc.tools.records.ndef.NdefRecord;

public abstract class ExternalRecord extends NdefRecord {

	private byte[] datas;

	public byte[] getDatas() {
		return datas;
	}

	public void setDatas(byte[] datas) {
		this.datas = datas;
	}

	public boolean hasDatas() {
		return datas != null;
	}

}
