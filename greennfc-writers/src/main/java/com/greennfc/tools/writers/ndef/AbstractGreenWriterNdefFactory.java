package com.greennfc.tools.writers.ndef;

import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.ndef.MimeTypeRecord;
import com.greennfc.tools.records.ndef.NdefRecord;
import com.greennfc.tools.writers.factory.IGreenWriterNdefFactory;

public abstract class AbstractGreenWriterNdefFactory implements IGreenWriterNdefFactory {

	protected AbstractGreenWriterNdefFactory() {
	}

	private NdefWriter<NdefRecord> ndefWriter;
	private MimeTypeWriter mimeTypeWriter;

	public IGreenWriter<NdefRecord> ndefWriter() {
		if (ndefWriter == null) {
			ndefWriter = new NdefWriter<NdefRecord>();
		}
		return ndefWriter;
	}

	public IGreenWriter<MimeTypeRecord> mimeTypeWriter() {
		if (mimeTypeWriter == null) {
			mimeTypeWriter = new MimeTypeWriter();
		}
		return mimeTypeWriter;
	}

}
