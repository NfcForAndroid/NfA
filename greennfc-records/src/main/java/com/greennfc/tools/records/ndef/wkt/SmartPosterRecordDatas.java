package com.greennfc.tools.records.ndef.wkt;

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

	public static SmartPosterRecordDatasBuilder instance() {
		return new SmartPosterRecordDatasBuilder();
	}

	public static final class SmartPosterRecordDatasBuilder {

		private SmartPosterRecordDatas datas;

		private SmartPosterRecordDatasBuilder() {
			datas = new SmartPosterRecordDatas();
		}

		public SmartPosterRecordDatasBuilder uri(UriRecord uri) {
			datas.uri = uri;
			return this;
		}

		public SmartPosterRecordDatasBuilder title(TextRecord title) {
			datas.title = title;
			return this;
		}

		public SmartPosterRecordDatas build() {
			return datas;
		}

	}

}
