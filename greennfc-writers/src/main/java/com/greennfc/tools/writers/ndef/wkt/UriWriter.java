package com.greennfc.tools.writers.ndef.wkt;

import java.io.UnsupportedEncodingException;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.greennfc.tools.records.ndef.wkt.UriRecord;
import com.greennfc.tools.records.ndef.wkt.UriSchemeEnum;
import com.greennfc.tools.writers.ndef.AbstractNdefWriter;

public class UriWriter extends AbstractNdefWriter<UriRecord> {

	protected UriWriter() {
	}

	public NdefMessage getMessageRecord() {

		NdefRecord ndefRecord = getNdefRecord();
		NdefRecord[] records = new NdefRecord[] { ndefRecord };
		NdefMessage msg = new NdefMessage(records);
		return msg;
	}

	private NdefRecord getNdefRecord() {
		if (!(record instanceof UriRecord)) {
			throw new IllegalArgumentException("Expected UriRecord but got : " + record.getClass());
		}

		String uri = record.getUri().toString();
		byte[] uriAsBytes = getUriAsBytes(uri);

		int abbreviateIndex = getAbbreviateIndex(uri.toLowerCase());
		int uriCopyOffset = UriSchemeEnum.values()[abbreviateIndex].getCode();
		byte[] payload = new byte[uriAsBytes.length + 1 - uriCopyOffset];
		payload[0] = (byte) abbreviateIndex;
		System.arraycopy(uriAsBytes, uriCopyOffset, payload, 1, uriAsBytes.length - uriCopyOffset);

		NdefRecord ndefRecord = new NdefRecord(NdefRecord.TNF_ABSOLUTE_URI, NdefRecord.RTD_URI, record.getId(), payload);

		return ndefRecord;

	}

	private byte[] getUriAsBytes(String uri) {
		try {
			return uri.getBytes(UriRecord.DEFAULT_URI_CHARSET.name());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	private int getAbbreviateIndex(String uri) {
		int maxLength = 0;
		int abbreviateIndex = 0;
		for (int x = 1; x < UriSchemeEnum.values().length; x++) {

			String abbreviablePrefix = UriSchemeEnum.values()[x].getScheme();

			if (uri.startsWith(abbreviablePrefix) && abbreviablePrefix.length() > maxLength) {
				abbreviateIndex = x;
				maxLength = abbreviablePrefix.length();
			}
		}
		return abbreviateIndex;
	}

	@Override
	public int getLength() {
		super.ndefRecord = getNdefRecord();
		return super.getLength();
	}

}
