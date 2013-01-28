package com.greennfc.tools.parser;

import android.nfc.NdefRecord;

import com.greennfc.tools.api.IGreenIntentFilter;
import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.filters.ndef.ext.ExternalNdefFilter;
import com.greennfc.tools.filters.ndef.ext.TextExternalNdefFilter;
import com.greennfc.tools.parser.exceptions.UnknowExtTypeException;

public class NdefParser extends GreenParserAdapter {

	private IGreenIntentFilter[] filters;

	protected NdefParser(IGreenIntentFilter... filters) {
		this.filters = filters;
	}

	@Override
	public IGreenRecord parseNdef(NdefRecord ndefRecord) {
		short tnf = ndefRecord.getTnf();

		IGreenRecord record = null;
		switch (tnf) {
		case NdefRecord.TNF_EMPTY: {
			// record = EmptyRecord.parse(ndefRecord);

			break;
		}
		case NdefRecord.TNF_WELL_KNOWN: {
			record = parseWellKnown(ndefRecord);
			break;
		}
		case NdefRecord.TNF_MIME_MEDIA: {
			// record = MimeRecord.parse(ndefRecord);

			break;
		}
		case NdefRecord.TNF_ABSOLUTE_URI: {
			// record = AbsoluteUriRecord.parse(ndefRecord);

			break;
		}
		case NdefRecord.TNF_EXTERNAL_TYPE: {
			record = parseExt(ndefRecord);
			break;
		}
		case NdefRecord.TNF_UNKNOWN: {
			// record = UnknownRecord.parse(ndefRecord);

			break;
		}
		/*
		 * case NdefRecord.TNF_UNCHANGED: { throw new IllegalArgumentException("Chunked records no supported"); // chunks are abstracted away by android so should never happen }
		 */

		}

		if (record == null) { // pass through
			// record = UnsupportedRecord.parse(ndefRecord);
		}

		if (ndefRecord.getId().length > 0) {
			// record.setId(ndefRecord.getId());
		}

		return record;
	}

	protected IGreenRecord parseExt(NdefRecord ndefRecord) {
		if (this.filters == null || this.filters.length == 0) {
			throw new UnknowExtTypeException("You don't have passed any filters to identify the current record.");
		}
		IGreenRecord record = null;
		String path = null;
		String type = null;
		for (IGreenIntentFilter filter : filters) {
			path = filter.getDataPath();
			if (path != null) {
				if (path.charAt(0) == '/') {
					path = path.substring(1);
				}
				type = new String(ndefRecord.getType());
				if (path.equals(type)) {
					if (filter instanceof ExternalNdefFilter) {
						record = GreenParserFactory.externalFactory().externalParser().parseNdef(ndefRecord);
						break;
					} else if (filter instanceof TextExternalNdefFilter) {
						record = GreenParserFactory.externalFactory().externalTextParser().parseNdef(ndefRecord);
						break;
					}
				}
			}
		}
		if (record == null) {
			type = new String(ndefRecord.getType());
			throw new UnknowExtTypeException("type not found : " + type);

		}
		return record;
	}

	protected static IGreenRecord parseWellKnown(NdefRecord ndefRecord) {

		// lame type search among supported types
		byte[] type = ndefRecord.getType();
		if (type.length == 1) {
			// uri = U
			// text = T
			// gctarget = t
			// gcdata = d
			// gcaction a
			switch (type[0]) {
			case 'U': {
				return null;// UriRecord.parseNdefRecord(ndefRecord);
			}
			case 'T': {

				return GreenParserFactory.wellKnowTypeFactory().textParser().parseNdef(ndefRecord);
			}
			case 't': {

				return null;// GcTargetRecord.parseNdefRecord(ndefRecord);
			}
			case 'd': {

				return null;// GDataRecord.parseNdefRecord(ndefRecord);
			}
			case 'a': {

				return null;// GcActionRecord.parseNdefRecord(ndefRecord);
			}
			}

		} else if (type.length == 2) {

			// smartposter = Sp
			// genericcontrol = Gc
			// alternativecarrier = ac
			// handovercarrier = Hc
			// handoverselect = Hs
			// handoverrequest = Hr
			// collision resolution = cr

			switch (type[0]) {
			case 'S': {
				if (type[1] == 'p') {
					return null;// SmartPosterRecord.parseNdefRecord(ndefRecord);
				}
				break;
			}
			case 'G': {
				if (type[1] == 'c') {
					return null;// GenericControlRecord.parseNdefRecord(ndefRecord);
				}
				break;
			}
			case 'a': {

				if (type[1] == 'c') {
					return null;// AlternativeCarrierRecord.parseNdefRecord(ndefRecord);
				}
				break;
			}
			case 'c': {

				if (type[1] == 'r') {
					return null;// CollisionResolutionRecord.parseNdefRecord(ndefRecord);
				}
				break;
			}
			case 'H': {
				if (type[1] == 'c') {
					return null;// HandoverCarrierRecord.parseNdefRecord(ndefRecord);
				} else if (type[1] == 's') {
					return null;// HandoverSelectRecord.parseNdefRecord(ndefRecord);
				} else if (type[1] == 'r') {
					return null;// HandoverRequestRecord.parseNdefRecord(ndefRecord);
				}
				break;
			}
			}

		} else if (type.length == 3) {
			// action = act
			// error = err
			// signature = Sig
			if (type[0] == 'a' && type[1] == 'c' && type[2] == 't') {
				return null;// ActionRecord.parseNdefRecord(ndefRecord);
			} else if (type[0] == 'e' && type[1] == 'r' && type[2] == 'r') {
				return null;// ErrorRecord.parseNdefRecord(ndefRecord);
			} else if (type[0] == 'S' && type[1] == 'i' && type[2] == 'g') {
				return null;// SignatureRecord.parseNdefRecord(ndefRecord);
			}
		}

		return null;

	}

}
