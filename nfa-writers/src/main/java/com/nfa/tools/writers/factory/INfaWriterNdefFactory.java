package com.nfa.tools.writers.factory;

import com.nfa.tools.api.INfaWriter;
import com.nfa.tools.records.ndef.MimeTypeRecord;
import com.nfa.tools.records.ndef.NdefRecord;
import com.nfa.tools.records.ndef.UnknownRecord;
import com.nfa.tools.records.ndef.UnsupportedRecord;

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
