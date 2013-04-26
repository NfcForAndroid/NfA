package com.github.nfcforandroid.samples.game;

import com.github.nfcforandroid.samples.R;
import com.github.nfcforandroid.samples.cst.NfaSampleCst;
import com.github.nfcforandroid.samples.utils.AbstractNfaGameAndMarketWriter;

public class NfaGameWriter extends AbstractNfaGameAndMarketWriter {

	@Override
	protected int getTextContent() {
		return R.string.text_game;
	}

	@Override
	protected int getNbTags() {
		return 2;
	}

	@Override
	protected Class<?> getClassIntent() {
		return NfaGame.class;
	}

	@Override
	protected String getFilterPath() {
		return NfaSampleCst.TYPE_EXTERNAL_GAME;
	}

}
