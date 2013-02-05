package com.greennfc.tools.samples.write;

import static com.greennfc.tools.filters.factory.GreenFiltersFactory.*;
import static com.greennfc.tools.records.factory.GreenRecordFactory.*;
import static com.greennfc.tools.v14.GreenNfcFactory.*;
import static com.greennfc.tools.writers.factory.GreenWriterFactory.*;
import android.content.Intent;
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
import com.greennfc.tools.api.IGreenIntentWrite;
import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.factory.GreenRecordFactory;
import com.greennfc.tools.samples.R;

public class GreenWriteActivity //
		extends SherlockFragmentActivity //
		implements IGreenIntentWrite //
{

	private TextView tag_content;
	private Spinner type_tag;
	private EditText text_content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write);

		tag_content = (TextView) findViewById(R.id.tag_content);
		type_tag = (Spinner) findViewById(R.id.spinnerType);
		text_content = (EditText) findViewById(R.id.RecieveMsg);
		text_content.setEnabled(false);

		type_tag.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> root, View view, int pos, long arg3) {
				switch (pos) {
				case 0:
					text_content.setEnabled(false);
					break;
				case 1:
					text_content.setEnabled(true);
					break;
				case 2:
					text_content.setEnabled(true);
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
				, NDEF_FILTER //
				);

	}

	@Override
	protected void onNewIntent(Intent intent) {
		/*
		 * Manadatory
		 */
		tag_content.setText(R.string.writing_tag);
		write(intent);
	}

	private <Record extends IGreenRecord> void write(Intent intent) {
		IGreenWriter<Record> writer = null;
		Record record = null;
		switch (type_tag.getSelectedItemPosition()) {
		case 0:
			writer = (IGreenWriter<Record>) EMPTY_WRITER;
			record = (Record) EMPTY_RECORD;
			break;
		case 1:
			writer = (IGreenWriter<Record>) TEXT_WRITER;
			record = (Record) GreenRecordFactory.wellKnowTypeFactory().textRecordInstance(text_content.getText().toString());
			break;
		case 2:
			writer = (IGreenWriter<Record>) URI_WRITER;
			record = (Record) GreenRecordFactory.wellKnowTypeFactory().uriRecordInstance(text_content.getText().toString());

			break;

		default:
			break;
		}

		GREEN_NFC_MANAGER.writeTag(intent, this, writer, record);
	}

	/**
	 * 
	 * Green NFC methods
	 **/

	@Override
	public void messageWrite(boolean ok) {
		tag_content.setText(ok ? R.string.tag_write : R.string.tag_not_write);

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
			tag_content.setText(R.string.wating_tag);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
