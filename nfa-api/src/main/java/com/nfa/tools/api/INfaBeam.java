package com.nfa.tools.api;

import java.util.List;

import com.nfa.tools.api.beans.NfaWriteBean;

public interface INfaBeam<Record extends INfaRecord> {

	List<NfaWriteBean<Record>> getWriters();

	void beamCallBack();

	boolean addAndroidApplicationRecord();

}
