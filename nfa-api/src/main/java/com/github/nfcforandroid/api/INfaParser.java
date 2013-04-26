package com.github.nfcforandroid.api;

import android.nfc.NdefRecord;
import android.nfc.Tag;

import com.github.nfcforandroid.exception.ParserException;

/**
 * @author jefBinomed
 * 
 *         This interface is used when you want to read datas.
 * 
 *         You should implement this interface when you want to add a new way to parse a special {@link INfaRecord}
 * 
 *         A set of implementations exists in the nfa-parsers module
 * 
 */
public interface INfaParser {

	/**
	 * This methods gives to the parser the list of filters identify by the client side for the information about the tag to parse
	 * 
	 * @param filters
	 *            the list of filters identify. Could be null;
	 */
	void setFilters(INfaIntentFilter... filters);

	/**
	 * Transform a {@link NdefRecord} to the expected output
	 * 
	 * @param record
	 *            the android {@link NdefRecord} message
	 * 
	 * @return a record corresponding to the datas contains by the record. <code>null</code> if there is no data in it.
	 * @throws ParserException
	 */
	<Record extends INfaRecord> Record parseNdef(NdefRecord record) throws ParserException;

	/**
	 * Transform a {@link Tag} to the expected output
	 * 
	 * @param tag
	 *            the android {@link Tag} message
	 * @return a record corresponding to the datas contains by the record. <code>null</code> if there is no data in it.
	 * @throws ParserException
	 */
	<Record extends INfaRecord> Record parseTag(Tag tag) throws ParserException;

}
