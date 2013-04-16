package com.nfa.tools.writers.factory;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.MimeTypeRecord;
import com.nfa.tools.records.ndef.NdefRecord;
import com.nfa.tools.records.ndef.UnknownRecord;
import com.nfa.tools.records.ndef.UnsupportedRecord;

public interface INfaWriterNdefFactory {

	INfaWriter<NdefRecord> ndefWriter();

	INfaWriter<MimeTypeRecord> mimeTypeWriter();

	INfaWriter<UnknownRecord> unknownWriter();

	INfaWriter<UnsupportedRecord> unsupportedWriter();

}
