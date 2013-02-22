package com.greennfc.tools.samples.write;

import static com.greennfc.tools.v14.GreenNfcFactory.*;
import static com.greennfc.tools.writers.factory.GreenWriterFactory.*;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.greennfc.tools.api.IGreenBeam;
import com.greennfc.tools.api.beans.GreenWriteBean;
import com.greennfc.tools.api.beans.GreenWriteBean.GreenWriteBeanBuilder;
import com.greennfc.tools.records.factory.GreenRecordFactory;
import com.greennfc.tools.records.ndef.wkt.TextRecord;
import com.greennfc.tools.samples.R;

public class GreenBeamMultiActivity extends SherlockFragmentActivity implements IGreenBeam<TextRecord> {

	protected TextView msg_feedback, msg_feedback_error;
	protected EditText text_content_1, text_content_2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_beam_multi);

		msg_feedback = (TextView) findViewById(R.id.msg_feedback);
		msg_feedback_error = (TextView) findViewById(R.id.msg_feedback_error);
		text_content_1 = (EditText) findViewById(R.id.text_content_1);
		text_content_2 = (EditText) findViewById(R.id.text_content_2);
		msg_feedback_error.setVisibility(View.GONE);

		GREEN_NFC_MANAGER.register(this //
				, this //
				);
	}

	/**
	 * 
	 * Green NFC methods
	 **/

	@SuppressWarnings("unchecked")
	@Override
	public List<GreenWriteBean<TextRecord>> getWriters() {
		GreenWriteBeanBuilder<TextRecord> builder1 = GreenWriteBean.writeBeanConfigure();
		GreenWriteBeanBuilder<TextRecord> builder2 = GreenWriteBean.writeBeanConfigure();

		return Arrays.asList( //
				builder1 //
				.writer(TEXT_WRITER) //
						.record(GreenRecordFactory.wellKnowTypeFactory().textRecordInstance(text_content_1.getText().toString())) //
						.build() //
				, builder2 //
						.writer(TEXT_WRITER) //
						.record(GreenRecordFactory.wellKnowTypeFactory().textRecordInstance(text_content_2.getText().toString())) //
						.build() //
				);
	}

	@Override
	public void beamCallBack() {
		msg_feedback.setText(R.string.tag_write);

	}

	@Override
	public boolean addAndroidApplicationRecord() {
		return true;
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
