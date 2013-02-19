package com.greennfc.tools.writers.factory;

import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.MimeTypeRecord;
import com.greennfc.tools.records.ndef.NdefRecord;
import com.greennfc.tools.records.ndef.UnknownRecord;
import com.greennfc.tools.records.ndef.UnsupportedRecord;

public interface IGreenWriterNdefFactory {

	IGreenWriter<NdefRecord> ndefWriter();

	IGreenWriter<MimeTypeRecord> mimeTypeWriter();

	IGreenWriter<UnknownRecord> unknownWriter();

	IGreenWriter<UnsupportedRecord> unsupportedWriter();

}
