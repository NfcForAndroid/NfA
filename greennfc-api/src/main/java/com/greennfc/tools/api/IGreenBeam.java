package com.greennfc.tools.api;

import java.util.List;

import com.greennfc.tools.api.beans.GreenWriteBean;

public interface IGreenBeam<Record extends IGreenRecord> {

	List<GreenWriteBean<Record>> getWriters();

	void beamCallBack();

	boolean addAndroidApplicationRecord();

}
