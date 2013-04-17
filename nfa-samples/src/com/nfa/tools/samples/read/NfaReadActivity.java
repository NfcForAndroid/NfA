package com.nfa.tools.samples.read;

import static com.nfa.tools.api.beans.NfaRecieveBean.*;
import static com.nfa.tools.filters.factory.NfaFiltersFactory.*;
import static com.nfa.tools.parser.factory.NfaParserFactory.*;
import static com.nfa.tools.v14.NfaFactory.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.client.INfaIntentRecieveRecord;
import com.nfa.tools.records.ndef.MimeTypeRecord;
import com.nfa.tools.records.ndef.ext.TextExternalRecord;
import com.nfa.tools.records.ndef.wkt.SmartPosterRecord;
import com.nfa.tools.records.ndef.wkt.TextRecord;
import com.nfa.tools.records.ndef.wkt.UriRecord;
import com.nfa.tools.samples.R;
import com.nfa.tools.samples.cst.NfaSampleCst;

public class NfaReadActivity extends SherlockFragmentActivity implements INfaIntentRecieveRecord<INfaRecord> {

	TextView tag_content;
	ImageView tag_content_img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read);

		tag_content = (TextView) findViewById(R.id.tag_content);
		tag_content_img = (ImageView) findViewById(R.id.tag_content_img);
		tag_content_img.setVisibility(View.GONE);

		GREEN_NFC_MANAGER.register(this //
				, recieveBeanConfigure() //
						.intent(getIntent()) //
						.intentRecieveRecord(this) //
						.parser(NDEF_PARSER) //
						.build() //
				, NDEF_FILTER //
				, TEXT_FILTER //
				, externalFilters().textExternalNdefFilter(NfaSampleCst.TYPE_EXTERNAL) //
				);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		/*
		 * Manadatory
		 */
		tag_content.setText(R.string.reading_tag);
		GREEN_NFC_MANAGER.manageIntent(recieveBeanConfigure() //
				.intent(intent) //
				.intentRecieveRecord(this) //
				.parser(NDEF_PARSER) //
				.build());
	}

	/**
	 * 
	 * Green NFC methods
	 **/

	@Override
	public void recieveRecord(INfaRecord record) {
		tag_content_img.setVisibility(View.GONE);
		if (record instanceof TextRecord) {
			String message = ((TextRecord) record).getText();
			tag_content.setText(getString(R.string.tag_content) + message);
		} else if (record instanceof TextExternalRecord) {
			String message = ((TextExternalRecord) record).getMessage();
			tag_content.setText(getString(R.string.tag_content) + message);
		} else if (record instanceof UriRecord) {
			String message = ((UriRecord) record).getUri().toString();
			tag_content.setText(getString(R.string.tag_content) + message);
		} else if (record instanceof SmartPosterRecord) {
			SmartPosterRecord spRecord = ((SmartPosterRecord) record);
			String uri = spRecord.getUri().getUri().toString();
			String title = spRecord.getTitle() != null ? spRecord.getTitle().getText() : null;
			tag_content.setText(getString(R.string.tag_content) + (title != null ? title + " : " : "") + uri);
		} else if (record instanceof MimeTypeRecord) {
			tag_content.setVisibility(View.GONE);
			tag_content_img.setVisibility(View.VISIBLE);
			MimeTypeRecord mimeTypeRecord = ((MimeTypeRecord) record);
			ByteArrayInputStream is = new ByteArrayInputStream(mimeTypeRecord.getData());
			tag_content_img.setImageBitmap(BitmapFactory.decodeStream(is));
			try {
				is.close();
			} catch (IOException e) {
				// TODO
			}
		} else {
			tag_content.setText(R.string.tag_content);
		}

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
			tag_content.setVisibility(View.VISIBLE);
			tag_content_img.setVisibility(View.GONE);
			tag_content.setText(R.string.wating_tag);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
