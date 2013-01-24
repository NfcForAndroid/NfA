package com.greennfc.tools.samples.read;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.greennfc.tools.GreenNfcFactory;
import com.greennfc.tools.api.IGreenIntentRecieve;
import com.greennfc.tools.api.IGreenManager;
import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.filters.ndef.wkt.GreenFilterWellKnowTypeFactory;
import com.greennfc.tools.parser.GreenParserFactory;
import com.greennfc.tools.records.ndef.wkt.TextRecord;
import com.greennfc.tools.samples.R;

public class GreenReadActivity extends SherlockFragmentActivity implements IGreenIntentRecieve<IGreenRecord> {

	IGreenManager<IGreenRecord> nfcManager = null;

	TextView tag_content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read);

		tag_content = (TextView) findViewById(R.id.tag_content);

		nfcManager = GreenNfcFactory.newManager();
		nfcManager.register(this, GreenParserFactory.ndefParserInstance() //
				, GreenFilterWellKnowTypeFactory.textFilter() //
				);

	}

	@Override
	protected void onPause() {
		nfcManager.pause(this);
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		nfcManager.resume(this);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		nfcManager.manageIntent(intent);
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

	@Override
	public void recieveMessage(IGreenRecord record) {
		if (record instanceof TextRecord) {
			String message = ((TextRecord) record).getText();
			tag_content.setText(getString(R.string.tag_content) + message);
		} else {
			tag_content.setText(R.string.tag_content);
		}

	}

	@Override
	public void startRecieveMessage() {
		tag_content.setText(R.string.reading_tag);
	}

}
