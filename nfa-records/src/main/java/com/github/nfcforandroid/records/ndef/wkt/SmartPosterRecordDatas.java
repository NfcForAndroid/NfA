package com.github.nfcforandroid.records.ndef.wkt;


/**
 * @author jefBinomed
 * 
 * 
 *         The smart poster datas
 * 
 *         the class contains an uri record and a text record. In future version, you could add more types likes mime types, ...
 * 
 * @see SmartPosterRecord
 */
public final class SmartPosterRecordDatas {

	private UriRecord uri;
	private TextRecord title;

	private SmartPosterRecordDatas() {
	}

	protected UriRecord getUri() {
		return uri;
	}

	protected TextRecord getTitle() {
		return title;
	}

	/**
	 * @return a new instance of {@link SmartPosterRecordDatasBuilder} on each call
	 */
	public static SmartPosterRecordDatasBuilder instance() {
		return new SmartPosterRecordDatasBuilder();
	}

	/**
	 * @author jefBinomed
	 * 
	 *         Builder class for the creation of smartposter. If there is no uri field, the buikd couldn't be done
	 */
	public static final class SmartPosterRecordDatasBuilder {

		private SmartPosterRecordDatas datas;

		private SmartPosterRecordDatasBuilder() {
			datas = new SmartPosterRecordDatas();
		}

		/**
		 * @param uri
		 *            the uri record
		 * @return the curent builder
		 */
		public SmartPosterRecordDatasBuilder uri(UriRecord uri) {
			datas.uri = uri;
			return this;
		}

		/**
		 * @param title
		 *            the texte record corresponding to title
		 * @return the curent builder
		 */
		public SmartPosterRecordDatasBuilder title(TextRecord title) {
			datas.title = title;
			return this;
		}

		/**
		 * @return the {@link SmartPosterRecordDatas} corresponding
		 * 
		 *         an {@link AssertionError} will be thrown if the uri record is empty
		 */
		public SmartPosterRecordDatas build() {
			assert datas.uri != null || datas.uri.hasUri() : "You have to specify at least the uri record";
			return datas;
		}

	}

}
