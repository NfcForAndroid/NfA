package com.nfa.tools.samples.write;

import static com.nfa.tools.v14.NfaFactory.*;
import static com.nfa.tools.writers.factory.NfaWriterFactory.*;

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
import com.nfa.tools.api.beans.NfaWriteBean;
import com.nfa.tools.api.beans.NfaWriteBean.NfaWriteBeanBuilder;
import com.nfa.tools.api.client.INfaBeam;
import com.nfa.tools.records.factory.NfaRecordFactory;
import com.nfa.tools.records.ndef.wkt.TextRecord;
import com.nfa.tools.samples.R;

public class NfaBeamMultiActivity extends SherlockFragmentActivity implements INfaBeam<TextRecord> {

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
	public List<NfaWriteBean<TextRecord>> getWriters() {
		NfaWriteBeanBuilder<TextRecord> builder1 = NfaWriteBean.writeBeanConfigure();
		NfaWriteBeanBuilder<TextRecord> builder2 = NfaWriteBean.writeBeanConfigure();

		return Arrays.asList( //
				builder1 //
				.writer(TEXT_WRITER) //
						.record(NfaRecordFactory.wellKnowTypeFactory().textRecordInstance(text_content_1.getText().toString())) //
						.build() //
				, builder2 //
						.writer(TEXT_WRITER) //
						.record(NfaRecordFactory.wellKnowTypeFactory().textRecordInstance(text_content_2.getText().toString())) //
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
