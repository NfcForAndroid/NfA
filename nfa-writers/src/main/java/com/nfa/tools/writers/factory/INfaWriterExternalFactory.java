package com.nfa.tools.writers.factory;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.ext.AndroidApplicationRecord;

public interface INfaWriterExternalFactory {

	INfaWriter<AndroidApplicationRecord> androidApplicationWriter();

}
