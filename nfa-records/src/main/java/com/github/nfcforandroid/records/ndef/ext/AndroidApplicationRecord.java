package com.github.nfcforandroid.records.ndef.ext;

import android.content.Context;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.records.ndef.WrongReccordDatasException;

/**
 * @author jefBinomed
 * 
 *         {@link INfaRecord} for Android Application Record data.
 * 
 *         An {@link WrongReccordDatasException} will be thrown if the package name doesn't respect package name convention
 */
public class AndroidApplicationRecord extends ExternalRecord {

	private static final String JAVA_PACKAGE_CONVENSION = "^[a-z]+(\\.[a-zA-Z_][a-zA-Z0-9_]*)*$"; //

	protected AndroidApplicationRecord(Context context) {
		this(context.getPackageName());
	}

	protected AndroidApplicationRecord(String packageName) {
		super();
		if (packageName == null || !packageName.matches(JAVA_PACKAGE_CONVENSION)) {
			throw new WrongReccordDatasException("the package name is not a valid name : " + packageName);
		}
		setDatas(packageName.getBytes());
	}

	/**
	 * @return the package name contained
	 */
	public String getPackageName() {
		return new String(getDatas());
	}

	/**
	 * @return <code>true</code> if there is datas, <code>false</code> else
	 */
	public boolean hasPackageName() {
		return hasDatas();
	}

}
