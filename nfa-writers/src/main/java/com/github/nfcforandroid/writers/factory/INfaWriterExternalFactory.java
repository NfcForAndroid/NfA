package com.github.nfcforandroid.writers.factory;

import com.github.nfcforandroid.api.INfaWriter;
import com.github.nfcforandroid.records.ndef.ext.AndroidApplicationRecord;
import com.github.nfcforandroid.records.ndef.ext.ExternalRecord;
import com.github.nfcforandroid.records.ndef.ext.TextExternalRecord;
import com.github.nfcforandroid.records.ndef.ext.UriExternalRecord;

/**
 * @author jefBinomed
 * 
 * 
 *         Factory for getting {@link INfaWriter} that are externals
 */
public interface INfaWriterExternalFactory {

	/**
	 * @return a singleton instance of android application record writer
	 */
	INfaWriter<AndroidApplicationRecord> androidApplicationWriter();

	/**
	 * @return a singleton instance of external record writer
	 */
	INfaWriter<ExternalRecord> externalWriter();

	/**
	 * @return a singleton instance of external text record writer
	 */
	INfaWriter<TextExternalRecord> externalTextWriter();

	/**
	 * @return a singleton instance of external uri record writer
	 */
	INfaWriter<UriExternalRecord> externalUriWriter();

}
