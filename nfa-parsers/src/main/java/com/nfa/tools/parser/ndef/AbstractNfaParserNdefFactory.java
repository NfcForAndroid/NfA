package com.nfa.tools.parser.ndef;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.parser.factory.INfaParserNdefFactory;

public abstract class AbstractNfaParserNdefFactory implements INfaParserNdefFactory {

	private NdefParser ndefParser;
	private MimeTypeParser mimeTypeParser;
	private UnknownParser unknownParser;
	private UnsupportedParser unsupportedParser;

	protected AbstractNfaParserNdefFactory() {
	}

	public INfaParser ndefParser() {
		if (ndefParser == null) {
			ndefParser = new NdefParser();
		}
		return ndefParser;
	}

	public INfaParser mimeTypeParser() {
		if (mimeTypeParser == null) {
			mimeTypeParser = new MimeTypeParser();
		}
		return mimeTypeParser;
	}

	public INfaParser unknownParser() {
		if (unknownParser == null) {
			unknownParser = new UnknownParser();
		}
		return unknownParser;
	}

	public INfaParser unsupportedParser() {
		if (unsupportedParser == null) {
			unsupportedParser = new UnsupportedParser();
		}
		return unsupportedParser;
	}

}
