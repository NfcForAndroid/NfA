package com.nfa.tools.parser.ndef;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.parser.factory.INfaParserNdefFactory;
import com.nfa.tools.parser.factory.NfaParserFactory;

/**
 * @author jefBinomed
 * 
 *         Abstract class for the management of ndef parser factory. Will be implemented in {@link NfaParserFactory}
 * 
 */
public abstract class AbstractNfaParserNdefFactory implements INfaParserNdefFactory {

	private NdefParser ndefParser;
	private MimeTypeParser mimeTypeParser;
	private UnknownParser unknownParser;
	private UnsupportedParser unsupportedParser;

	protected AbstractNfaParserNdefFactory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.factory.INfaParserNdefFactory#ndefParser()
	 */
	public INfaParser ndefParser() {
		if (ndefParser == null) {
			ndefParser = new NdefParser();
		}
		return ndefParser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.factory.INfaParserNdefFactory#mimeTypeParser()
	 */
	public INfaParser mimeTypeParser() {
		if (mimeTypeParser == null) {
			mimeTypeParser = new MimeTypeParser();
		}
		return mimeTypeParser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.factory.INfaParserNdefFactory#unknownParser()
	 */
	public INfaParser unknownParser() {
		if (unknownParser == null) {
			unknownParser = new UnknownParser();
		}
		return unknownParser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.factory.INfaParserNdefFactory#unsupportedParser()
	 */
	public INfaParser unsupportedParser() {
		if (unsupportedParser == null) {
			unsupportedParser = new UnsupportedParser();
		}
		return unsupportedParser;
	}

}
