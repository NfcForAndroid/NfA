package com.greennfc.tools.samples.read;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.greennfc.tools.GreenNfcFactory;
import com.greennfc.tools.api.IGreenManager;
import com.greennfc.tools.samples.R;

public class GreenReadActivity extends Activity {

	IGreenManager nfcManager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read);

		nfcManager = GreenNfcFactory.newManager();
		nfcManager.register(this);
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
		nfcManager.manageIntent(intent);
	}

}
