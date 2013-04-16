package com.nfa.tools.writers.factory;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.INfaWriter;

public interface INfaWriterBaseFactory {

	INfaWriter<INfaRecord> emptyWriter();

}
