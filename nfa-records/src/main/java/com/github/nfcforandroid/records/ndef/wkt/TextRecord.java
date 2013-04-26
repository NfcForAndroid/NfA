package com.github.nfcforandroid.records.ndef.wkt;

import java.nio.charset.Charset;
import java.util.Locale;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.records.AbstractRecord;
import com.github.nfcforandroid.records.ndef.INdefRecord;

/**
 * @author jefBinomed
 * 
 *         {@link INfaRecord} for text data.
 * 
 *         This class contains a text, an encoding and a locale
 */
public final class TextRecord extends AbstractRecord implements INdefRecord {

	/**
	 * The default mask to use for analysing the language code in the ndef message
	 */
	public static final byte LANGUAGE_CODE_MASK = 0x1F;

	public static final Charset UTF8 = Charset.forName("UTF-8");
	public static final Charset UTF16 = Charset.forName("UTF-16BE");

	private String text;
	private Charset encoding;
	private Locale locale;

	protected TextRecord(String key, String text) {
		this(text, UTF8, Locale.getDefault());
		setKey(key);
	}

	protected TextRecord(String text) {
		this(text, UTF8, Locale.getDefault());
	}

	protected TextRecord(String text, Locale locale) {
		this(text, UTF8, locale);
	}

	protected TextRecord(String text, Charset encoding, Locale locale) {
		this.encoding = encoding;
		this.text = text;
		this.locale = locale;
		if (!encoding.equals(UTF8) && !encoding.equals(UTF16))
			throw new IllegalArgumentException("unsupported encoding. only utf8 and utf16 are allowed.");
	}

	protected TextRecord() {
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @return the encoding
	 */
	public Charset getEncoding() {
		return encoding;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: [");

		if (hasKey())
			sb.append("Key/Id: ").append(getKey()).append(", ");

		sb.append("Text: ").append(text).append(", ");
		sb.append("Locale: " + locale.getLanguage()).append(locale.getCountry() == null || locale.getCountry().length() == 0 ? "" : ("-" + locale.getCountry()));

		sb.append("]");
		return sb.toString();
	}

	/**
	 * @return <code>true</code> if there is text, <code>false</code> else
	 */
	public boolean hasText() {
		return text != null;
	}

	/**
	 * @return <code>true</code> if there is a locale, <code>false</code> else
	 */
	public boolean hasLocale() {
		return locale != null;
	}

	/**
	 * @return <code>true</code> if there is an encoding, <code>false</code> else
	 */
	public boolean hasEncoding() {
		return encoding != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.AbstractRecord#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((encoding == null) ? 0 : encoding.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.records.AbstractRecord#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextRecord other = (TextRecord) obj;
		if (encoding == null) {
			if (other.encoding != null)
				return false;
		} else if (!encoding.equals(other.encoding))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
