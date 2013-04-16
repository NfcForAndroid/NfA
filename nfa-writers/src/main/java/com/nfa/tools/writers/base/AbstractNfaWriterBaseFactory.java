package com.nfa.tools.writers.base;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.writers.factory.INfaWriterBaseFactory;

public abstract class AbstractNfaWriterBaseFactory implements INfaWriterBaseFactory {

	protected AbstractNfaWriterBaseFactory() {
	}

	private EmptyWriter emptyWriter;

	public INfaWriter<INfaRecord> emptyWriter() {
		if (emptyWriter == null) {
			emptyWriter = new EmptyWriter();
		}
		return emptyWriter;
	}

}
