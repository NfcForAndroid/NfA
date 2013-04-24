package com.github.nfcforandroid.samples.game;

import static com.github.nfcforandroid.filters.factory.NfaFiltersFactory.*;
import static com.github.nfcforandroid.v14.NfaFactory.*;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.github.nfcforandroid.samples.R;
import com.github.nfcforandroid.samples.cst.NfaSampleCst;

public class NfaGame extends SherlockActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_game);

		// Nfa initialisation
		NFA_MANAGER.register(this //
				, externalFilters().textExternalNdefFilter(NfaSampleCst.TYPE_EXTERNAL_GAME));
	}

}
