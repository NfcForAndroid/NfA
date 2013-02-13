package com.greennfc.tools.records.factory;

import com.greennfc.tools.records.ndef.MimeTypeRecord;

public interface IGreenRecordNdefFactory {

	MimeTypeRecord mimeRecordInstance(String mimeType, byte[] datas);

}
