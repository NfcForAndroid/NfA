package com.github.nfcforandroid.samples.utils;

import static com.github.nfcforandroid.filters.factory.NfaFiltersFactory.*;
import static com.github.nfcforandroid.v14.NfaFactory.*;
import static com.github.nfcforandroid.writers.factory.NfaWriterFactory.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.github.nfcforandroid.api.beans.NfaWriteBean;
import com.github.nfcforandroid.api.beans.NfaWriteBean.NfaWriteBeanBuilder;
import com.github.nfcforandroid.api.client.INfaIntentWrite;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;
import com.github.nfcforandroid.records.ndef.ext.TextExternalRecord;
import com.github.nfcforandroid.samples.R;

public abstract class AbstractNfaGameAndMarketWriter extends SherlockActivity implements OnClickListener {

	TextView feedBack1, feedBack2, feedBack3, textContent;
	Button btnSkip, btnNext, btnInit;
	int curentTag = 0;
	int nbTags = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_game_market_writer);

		// UI Initialisation
		textContent = (TextView) findViewById(R.id.text_content_1);
		feedBack1 = (TextView) findViewById(R.id.msg_tag_1);
		feedBack2 = (TextView) findViewById(R.id.msg_tag_2);
		feedBack3 = (TextView) findViewById(R.id.msg_tag_3);

		btnSkip = (Button) findViewById(R.id.btn_skip);
		btnNext = (Button) findViewById(R.id.btn_next);
		btnInit = (Button) findViewById(R.id.btn_init);

		feedBack1.setVisibility(View.GONE);
		feedBack2.setVisibility(View.GONE);
		feedBack3.setVisibility(View.GONE);
		btnNext.setVisibility(View.GONE);

		btnSkip.setOnClickListener(this);
		btnNext.setOnClickListener(this);
		btnInit.setOnClickListener(this);

		textContent.setText(getTextContent());
		nbTags = getNbTags();

		// Nfa initialisation
		NFA_MANAGER.register(this, NDEF_FILTER);

	}

	protected abstract String getFilterPath();

	protected abstract int getTextContent();

	protected abstract int getNbTags();

	protected abstract Class<?> getClassIntent();

	/**
	 * 
	 * Nfa Write application
	 * 
	 **/

	@SuppressWarnings("unchecked")
	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);

		NfaWriteBeanBuilder<TextExternalRecord> writerBuilder = NfaWriteBean.writeBeanConfigure();
		NFA_MANAGER.writeTag(this // Context
				, intent // curent intent
				, new INfaIntentWrite() {

					@Override
					public void messageWrite(boolean ok, Exception error) {
						switch (curentTag) {
						case 0:
							feedBack1.setText(ok ? getString(R.string.game_write_tag1) : error.getMessage());
							if (ok) {
								curentTag++;
								feedBack2.setVisibility(View.VISIBLE);
							}
							break;
						case 1:
							feedBack2.setText(ok ? getString(R.string.game_write_tag2) : error.getMessage());
							if (ok) {
								curentTag++;
								if (nbTags == 3) {
									feedBack3.setVisibility(View.VISIBLE);
								} else {
									btnNext.setVisibility(View.VISIBLE);
								}
							}

							break;
						case 2:
							feedBack3.setText(ok ? getString(R.string.game_write_tag3) : error.getMessage());
							if (ok) {
								curentTag++;
								btnNext.setVisibility(View.VISIBLE);
							}

							break;

						default:
							break;
						}

					}
				}, true // Add Android Application Record
				, writerBuilder //
						.writer(EXTERNAL_TEXT_WRITER) //
						.record(NfaRecordFactory.externalFactory().textExternalRecordInstance(getFilterPath(), String.valueOf(curentTag))) //
						.build());
	}

	/**
	 * 
	 * UI Methods
	 * 
	 **/

	@Override
	public void onClick(View btn) {
		switch (btn.getId()) {
		case R.id.btn_init:
			btnInit.setEnabled(false);
			btnSkip.setEnabled(false);
			feedBack1.setVisibility(View.VISIBLE);
			break;
		case R.id.btn_next:
		case R.id.btn_skip:
			startActivity(new Intent(this, getClassIntent()));
			finish();
			break;

		default:
			break;
		}

	}

}
