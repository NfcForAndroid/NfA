package com.nfa.tools.records.ndef.ext;

import android.content.Context;

import com.nfa.tools.records.ndef.WrongReccordDatasException;

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

	public String getPackageName() {
		return new String(getDatas());
	}

	public boolean hasPackageName() {
		return hasDatas();
	}

}
