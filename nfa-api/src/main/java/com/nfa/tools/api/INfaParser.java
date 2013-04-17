package com.nfa.tools.api;

import android.nfc.NdefRecord;
import android.nfc.Tag;

import com.nfa.tools.exception.ParserException;

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
