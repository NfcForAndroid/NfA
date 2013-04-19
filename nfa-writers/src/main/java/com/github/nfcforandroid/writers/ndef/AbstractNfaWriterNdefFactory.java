package com.github.nfcforandroid.writers.ndef;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.MimeTypeRecord;
import com.github.nfcforandroid.records.ndef.NdefRecord;
import com.github.nfcforandroid.records.ndef.UnknownRecord;
import com.github.nfcforandroid.records.ndef.UnsupportedRecord;
import com.github.nfcforandroid.writers.factory.INfaWriterNdefFactory;
import com.github.nfcforandroid.writers.factory.NfaWriterFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of ndef writer factory. Will be implemented in {@link NfaWriterFactory}
 */
public abstract class AbstractNfaWriterNdefFactory implements INfaWriterNdefFactory {

	protected AbstractNfaWriterNdefFactory() {
	}

	private NdefWriter ndefWriter;
	private MimeTypeWriter mimeTypeWriter;
	private UnsupportedWriter unsupportedWriter;
	private UnknownWriter unknownWriter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterNdefFactory#ndefWriter()
	 */
	public INfaWriter<NdefRecord> ndefWriter() {
		if (ndefWriter == null) {
			ndefWriter = new NdefWriter();
		}
		return ndefWriter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterNdefFactory#mimeTypeWriter()
	 */
	public INfaWriter<MimeTypeRecord> mimeTypeWriter() {
		if (mimeTypeWriter == null) {
			mimeTypeWriter = new MimeTypeWriter();
		}
		return mimeTypeWriter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterNdefFactory#unknownWriter()
	 */
	public INfaWriter<UnknownRecord> unknownWriter() {
		if (unknownWriter == null) {
			unknownWriter = new UnknownWriter();
		}
		return unknownWriter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.writers.factory.INfaWriterNdefFactory#unsupportedWriter()
	 */
	public INfaWriter<UnsupportedRecord> unsupportedWriter() {
		if (unsupportedWriter == null) {
			unsupportedWriter = new UnsupportedWriter();
		}
		return unsupportedWriter;
	}

}
