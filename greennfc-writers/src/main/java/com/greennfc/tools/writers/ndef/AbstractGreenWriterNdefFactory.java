package com.greennfc.tools.writers.ndef;

import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.MimeTypeRecord;
import com.greennfc.tools.records.ndef.NdefRecord;
import com.greennfc.tools.records.ndef.UnknownRecord;
import com.greennfc.tools.records.ndef.UnsupportedRecord;
import com.greennfc.tools.writers.factory.IGreenWriterNdefFactory;

public abstract class AbstractGreenWriterNdefFactory implements IGreenWriterNdefFactory {

	protected AbstractGreenWriterNdefFactory() {
	}

	private NdefWriter ndefWriter;
	private MimeTypeWriter mimeTypeWriter;
	private UnsupportedWriter unsupportedWriter;
	private UnknownWriter unknownWriter;

	public IGreenWriter<NdefRecord> ndefWriter() {
		if (ndefWriter == null) {
			ndefWriter = new NdefWriter();
		}
		return ndefWriter;
	}

	public IGreenWriter<MimeTypeRecord> mimeTypeWriter() {
		if (mimeTypeWriter == null) {
			mimeTypeWriter = new MimeTypeWriter();
		}
		return mimeTypeWriter;
	}

	public IGreenWriter<UnknownRecord> unknownWriter() {
		if (unknownWriter == null) {
			unknownWriter = new UnknownWriter();
		}
		return unknownWriter;
	}

	public IGreenWriter<UnsupportedRecord> unsupportedWriter() {
		if (unsupportedWriter == null) {
			unsupportedWriter = new UnsupportedWriter();
		}
		return unsupportedWriter;
	}

}
