package com.nfa.tools.parser.ndef.wkt;

import java.nio.charset.Charset;
import java.util.Arrays;

import android.net.Uri;
import android.nfc.NdefRecord;

import com.nfa.tools.api.INfaParser;
import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.parser.ndef.NdefParser;
import com.nfa.tools.records.factory.NfaRecordFactory;
import com.nfa.tools.records.ndef.wkt.UriRecord;
import com.nfa.tools.records.ndef.wkt.UriSchemeEnum;

/**
 * @author jefBinomed
 * 
 *         {@link INfaParser} for Uri data.
 * 
 *         The return value is a {@link UriRecord}
 * 
 * 
 */
public final class UriParser extends NdefParser {

	protected UriParser() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nfa.tools.parser.ndef.NdefParser#parseNdef(android.nfc.NdefRecord)
	 */
	@Override
	public INfaRecord parseNdef(NdefRecord ndefRecord) {

		if (android.os.Build.VERSION.SDK_INT >= 16) {
			return NfaRecordFactory.wellKnowTypeFactory().uriRecordInstance(ndefRecord.toUri());
		} else {
			byte[] payload = ndefRecord.getPayload();
			if (payload.length < 2) {
				return null;
			}

			// payload[0] contains the URI Identifier Code, as per
			// NFC Forum "URI Record Type Definition" section 3.2.2.
			int prefixIndex = (payload[0] & (byte) 0xFF);
			if (prefixIndex < 0 || prefixIndex >= UriSchemeEnum.values().length) {
				return null;
			}
			String prefix = UriSchemeEnum.values()[prefixIndex].getScheme();
			String suffix = new String(Arrays.copyOfRange(payload, 1, payload.length), Charset.forName("UTF-8"));
			return NfaRecordFactory.wellKnowTypeFactory().uriRecordInstance(Uri.parse(prefix + suffix));
		}
	}

}
