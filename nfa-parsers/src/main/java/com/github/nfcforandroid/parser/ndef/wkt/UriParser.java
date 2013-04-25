package com.github.nfcforandroid.parser.ndef.wkt;

import java.nio.charset.Charset;
import java.util.Arrays;

import android.net.Uri;
import android.nfc.NdefRecord;

import com.github.nfcforandroid.api.INfaParser;
import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.parser.ndef.NdefParser;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;
import com.github.nfcforandroid.records.ndef.wkt.UriRecord;
import com.github.nfcforandroid.records.ndef.wkt.UriSchemeEnum;

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
	 * @see com.github.nfcforandroid.parser.ndef.NdefParser#parseNdef(android.nfc.NdefRecord)
	 */
	@Override
	public INfaRecord parseNdef(NdefRecord ndefRecord) {
		if (android.os.Build.VERSION.SDK_INT >= 16) {
			return NfaRecordFactory.wellKnowTypeRecords().uriRecordInstance(ndefRecord.toUri());
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
			return NfaRecordFactory.wellKnowTypeRecords().uriRecordInstance(Uri.parse(prefix + suffix));
		}

	}

}
