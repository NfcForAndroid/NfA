package com.greennfc.tools.samples.write;

import static com.greennfc.tools.records.factory.GreenRecordFactory.*;
import static com.greennfc.tools.v14.GreenNfcFactory.*;
import static com.greennfc.tools.writers.factory.GreenWriterFactory.*;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.greennfc.tools.api.IGreenBeam;
import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.factory.GreenRecordFactory;
import com.greennfc.tools.records.ndef.wkt.SmartPosterRecordDatas;
import com.greennfc.tools.samples.R;

public class GreenBeamActivity //
		extends SherlockFragmentActivity //
		implements IGreenBeam<IGreenRecord> //
{

	private TextView msg_feedback, msg_feedback_error;
	private Spinner type_tag, uri_prefix;
	private EditText tag_content, content_bis;

	private static final int TAG_EMPTY = 0;
	private static final int TAG_TEXT = 1;
	private static final int TAG_URI = 2;
	private static final int TAG_SMART_POSTER = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write);

		msg_feedback = (TextView) findViewById(R.id.msg_feedback);
		msg_feedback_error = (TextView) findViewById(R.id.msg_feedback_error);
		type_tag = (Spinner) findViewById(R.id.spinnerType);
		uri_prefix = (Spinner) findViewById(R.id.uri_prefix);
		tag_content = (EditText) findViewById(R.id.tag_content);
		content_bis = (EditText) findViewById(R.id.content_bis);
		tag_content.setEnabled(false);
		uri_prefix.setVisibility(View.GONE);
		content_bis.setVisibility(View.GONE);
		msg_feedback_error.setVisibility(View.GONE);

		type_tag.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> root, View view, int pos, long arg3) {
				switch (pos) {
				case TAG_EMPTY:
					tag_content.setEnabled(false);
					tag_content.setHint("");
					content_bis.setVisibility(View.GONE);
					uri_prefix.setVisibility(View.GONE);
					break;
				case TAG_TEXT:
					tag_content.setEnabled(true);
					tag_content.setHint(R.string.type_text);
					content_bis.setVisibility(View.GONE);
					uri_prefix.setVisibility(View.GONE);
					break;
				case TAG_URI:
					tag_content.setEnabled(true);
					tag_content.setHint(R.string.type_uri);
					content_bis.setVisibility(View.GONE);
					uri_prefix.setVisibility(View.VISIBLE);
					break;
				case TAG_SMART_POSTER:
					tag_content.setEnabled(true);
					tag_content.setHint(R.string.type_uri);
					content_bis.setVisibility(View.VISIBLE);
					uri_prefix.setVisibility(View.VISIBLE);
					break;

				default:
					break;
				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		GREEN_NFC_MANAGER.register(this //
				, this //
				);

	}

	@SuppressWarnings("unchecked")
	private <Record extends IGreenRecord> IGreenWriter<Record> writer() {
		IGreenWriter<Record> writer = null;
		Record record = null;
		switch (type_tag.getSelectedItemPosition()) {
		case TAG_EMPTY: {
			writer = (IGreenWriter<Record>) EMPTY_WRITER;
			record = (Record) EMPTY_RECORD;
			break;
		}
		case TAG_TEXT: {
			writer = (IGreenWriter<Record>) TEXT_WRITER;
			record = (Record) GreenRecordFactory.wellKnowTypeFactory().textRecordInstance(tag_content.getText().toString());
			break;
		}
		case TAG_URI: {
			writer = (IGreenWriter<Record>) URI_WRITER;
			String uriPrefix = this.uri_prefix.getSelectedItem().toString();
			String uri = uriPrefix.length() > 0 ? uriPrefix + tag_content.getText().toString() : tag_content.getText().toString();
			record = (Record) GreenRecordFactory.wellKnowTypeFactory().uriRecordInstance(uri);

			break;
		}
		case TAG_SMART_POSTER: {
			writer = (IGreenWriter<Record>) SMART_POSTER_WRITER;
			String uriSmartPoster = tag_content.getText().toString();
			String titleSmartPoster = content_bis.getText().toString();
			String uriPrefix = this.uri_prefix.getSelectedItem().toString();
			String uri = uriPrefix.length() > 0 ? uriPrefix + uriSmartPoster : uriSmartPoster;
			record = (Record) GreenRecordFactory.wellKnowTypeFactory().smartPosterRecordInstance( //
					SmartPosterRecordDatas.instance() //
							.uri(GreenRecordFactory.wellKnowTypeFactory().uriRecordInstance(uri)) //
							.title(GreenRecordFactory.wellKnowTypeFactory().textRecordInstance(titleSmartPoster)) //
							.build()//
					);

			break;
		}
		default:
			break;
		}
		writer.init(record);
		return writer;

	}

	/**
	 * 
	 * Green NFC methods
	 **/

	@Override
	public IGreenWriter<IGreenRecord> getWriter() {
		return writer();
	}

	@Override
	public void beamCallBack() {
		msg_feedback.setText(R.string.tag_write);

	}

	/**
	 * Action Bar management
	 **/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.activity_read_items, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.rescan_item:
			msg_feedback.setText(R.string.wating_tag);
			msg_feedback_error.setVisibility(View.GONE);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
