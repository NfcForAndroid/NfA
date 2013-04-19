package com.github.nfcforandroid.records.ndef.ext;

import com.github.nfcforandroid.records.AbstractRecord;
import com.github.nfcforandroid.records.ndef.INdefRecord;

/**
 * @author jefBinomed Abstract class for external type. It only contains an array of byte.
 */
public abstract class ExternalRecord extends AbstractRecord implements INdefRecord {

	private byte[] datas;

	/**
	 * @return the contained datas
	 */
	public byte[] getDatas() {
		return datas;
	}

	/**
	 * @param datas
	 */
	public void setDatas(byte[] datas) {
		this.datas = datas;
	}

	/**
	 * @return <code>true</code> if the datas are not <code>null</code>, <code>false</code> else
	 */
	public boolean hasDatas() {
		return datas != null;
	}

}
