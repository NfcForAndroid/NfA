package com.github.nfcforandroid.samples;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Create the list fragment and add it as our sole content.
		if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
			MainFragmentList list = new MainFragmentList();
			getSupportFragmentManager().beginTransaction().add(android.R.id.content, list).commit();
		}
	}

}
