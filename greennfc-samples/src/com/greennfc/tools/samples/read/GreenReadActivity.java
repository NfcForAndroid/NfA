package com.greennfc.tools.samples.read;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.greennfc.tools.GreenNfcFactory;
import com.greennfc.tools.api.IGreenManager;
import com.greennfc.tools.samples.R;

public class GreenReadActivity extends SherlockFragmentActivity {

	IGreenManager nfcManager = null;

	TextView tag_content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read);

		nfcManager = GreenNfcFactory.newManager();
		nfcManager.register(this);

		tag_content = (TextView) findViewById(R.id.tag_content);
	}

	@Override
	protected void onPause() {
		nfcManager.pause(this);
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		nfcManager.initIntent();
		nfcManager.resume(this);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		tag_content.setText(R.string.reading_tag);
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

}
