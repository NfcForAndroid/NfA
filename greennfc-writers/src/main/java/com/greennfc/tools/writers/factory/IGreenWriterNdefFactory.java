package com.greennfc.tools.writers.factory;

import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.MimeTypeRecord;
import com.greennfc.tools.records.ndef.NdefRecord;

public interface IGreenWriterNdefFactory {

	IGreenWriter<NdefRecord> ndefWriter();

	IGreenWriter<MimeTypeRecord> mimeTypeWriter();

}
