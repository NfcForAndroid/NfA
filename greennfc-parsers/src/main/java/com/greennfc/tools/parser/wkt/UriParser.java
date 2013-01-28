package com.greennfc.tools.parser.wkt;

import java.nio.charset.Charset;
import java.util.Arrays;

import android.net.Uri;
import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.parser.base.NdefParser;
import com.greennfc.tools.records.ndef.wkt.UriRecord;
import com.greennfc.tools.records.ndef.wkt.UriSchemeEnum;

public final class UriParser extends NdefParser {

	protected UriParser() {
	}

	@Override
	public IGreenRecord parseNdef(NdefRecord ndefRecord) {

		if (android.os.Build.VERSION.SDK_INT >= 16) {
			return new UriRecord(ndefRecord.toUri());
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
			return new UriRecord(Uri.parse(prefix + suffix));
		}
	}

}
