package com.nfa.tools.writers.ndef.ext;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.ext.AndroidApplicationRecord;
import com.nfa.tools.writers.factory.INfaWriterExternalFactory;

public abstract class AbstractNfaWriterExternalFactory implements INfaWriterExternalFactory {

	protected AbstractNfaWriterExternalFactory() {
	}

	private AndroidApplicationWriter androidApplicationWriter;

	public INfaWriter<AndroidApplicationRecord> androidApplicationWriter() {
		if (androidApplicationWriter == null) {
			androidApplicationWriter = new AndroidApplicationWriter();
		}
		return androidApplicationWriter;
	}

}
