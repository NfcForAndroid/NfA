package com.github.nfcforandroid.writers.factory;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.MimeTypeRecord;
import com.github.nfcforandroid.records.ndef.NdefRecord;
import com.github.nfcforandroid.records.ndef.UnknownRecord;
import com.github.nfcforandroid.records.ndef.UnsupportedRecord;

/**
 * @author jefBinomed
 * 
 * 
 *         Factory for getting {@link INfaWriter} that are ndef
 */
public interface INfaWriterNdefFactory {

	/**
	 * @return a singleton instance of ndef writer
	 */
	INfaWriter<NdefRecord> ndefWriter();

	/**
	 * @return a singleton instance of mime type writer
	 */
	INfaWriter<MimeTypeRecord> mimeTypeWriter();

	/**
	 * @return a singleton instance of unkown writer
	 */
	INfaWriter<UnknownRecord> unknownWriter();

	/**
	 * @return a singleton instance of unsupported writer
	 */
	INfaWriter<UnsupportedRecord> unsupportedWriter();

}
