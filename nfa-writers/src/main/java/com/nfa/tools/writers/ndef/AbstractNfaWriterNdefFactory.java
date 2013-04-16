package com.nfa.tools.writers.ndef;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.MimeTypeRecord;
import com.nfa.tools.records.ndef.NdefRecord;
import com.nfa.tools.records.ndef.UnknownRecord;
import com.nfa.tools.records.ndef.UnsupportedRecord;
import com.nfa.tools.writers.factory.INfaWriterNdefFactory;

public abstract class AbstractNfaWriterNdefFactory implements INfaWriterNdefFactory {

	protected AbstractNfaWriterNdefFactory() {
	}

	private NdefWriter ndefWriter;
	private MimeTypeWriter mimeTypeWriter;
	private UnsupportedWriter unsupportedWriter;
	private UnknownWriter unknownWriter;

	public INfaWriter<NdefRecord> ndefWriter() {
		if (ndefWriter == null) {
			ndefWriter = new NdefWriter();
		}
		return ndefWriter;
	}

	public INfaWriter<MimeTypeRecord> mimeTypeWriter() {
		if (mimeTypeWriter == null) {
			mimeTypeWriter = new MimeTypeWriter();
		}
		return mimeTypeWriter;
	}

	public INfaWriter<UnknownRecord> unknownWriter() {
		if (unknownWriter == null) {
			unknownWriter = new UnknownWriter();
		}
		return unknownWriter;
	}

	public INfaWriter<UnsupportedRecord> unsupportedWriter() {
		if (unsupportedWriter == null) {
			unsupportedWriter = new UnsupportedWriter();
		}
		return unsupportedWriter;
	}

}
