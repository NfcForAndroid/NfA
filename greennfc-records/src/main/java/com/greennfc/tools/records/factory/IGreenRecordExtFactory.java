package com.greennfc.tools.records.factory;

import com.greennfc.tools.records.ndef.ext.TextExternalRecord;

public interface IGreenRecordExtFactory {

	TextExternalRecord textExternalRecordInstance(String text);

}
