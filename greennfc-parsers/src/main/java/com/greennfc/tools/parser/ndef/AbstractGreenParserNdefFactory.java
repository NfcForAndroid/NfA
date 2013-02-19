package com.greennfc.tools.parser.ndef;

import com.greennfc.tools.api.IGreenParser;
import com.greennfc.tools.parser.factory.IGreenParserNdefFactory;

public abstract class AbstractGreenParserNdefFactory implements IGreenParserNdefFactory {

	private NdefParser ndefParser;
	private MimeTypeParser mimeTypeParser;
	private UnknownParser unknownParser;
	private UnsupportedParser unsupportedParser;

	protected AbstractGreenParserNdefFactory() {
	}

	public IGreenParser ndefParser() {
		if (ndefParser == null) {
			ndefParser = new NdefParser();
		}
		return ndefParser;
	}

	public IGreenParser mimeTypeParser() {
		if (mimeTypeParser == null) {
			mimeTypeParser = new MimeTypeParser();
		}
		return mimeTypeParser;
	}

	public IGreenParser unknownParser() {
		if (unknownParser == null) {
			unknownParser = new UnknownParser();
		}
		return unknownParser;
	}

	public IGreenParser unsupportedParser() {
		if (unsupportedParser == null) {
			unsupportedParser = new UnsupportedParser();
		}
		return unsupportedParser;
	}

}
