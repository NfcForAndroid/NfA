package com.greennfc.tools.records.ndef.ext;

import com.greennfc.tools.records.AbstractRecord;
import com.greennfc.tools.records.ndef.INdefRecord;

public abstract class ExternalRecord extends AbstractRecord implements INdefRecord {

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
