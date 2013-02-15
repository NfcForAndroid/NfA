package com.greennfc.tools.api;


public interface IGreenBeam<Record extends IGreenRecord> {

	IGreenWriter<Record> getWriter();

	void beamCallBack();

}
