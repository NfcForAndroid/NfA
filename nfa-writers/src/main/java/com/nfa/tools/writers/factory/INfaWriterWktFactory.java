package com.nfa.tools.writers.factory;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecord;
import com.nfa.tools.records.ndef.wkt.TextRecord;
import com.nfa.tools.records.ndef.wkt.UriRecord;

public interface INfaWriterWktFactory {

	INfaWriter<TextRecord> textWriter();

	INfaWriter<UriRecord> uriWriter();

	INfaWriter<SmartPosterRecord> smartPosterWriter();
}
