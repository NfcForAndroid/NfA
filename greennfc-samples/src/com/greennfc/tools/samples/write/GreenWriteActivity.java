package com.greennfc.tools.samples.write;

import static com.greennfc.tools.filters.factory.GreenFiltersFactory.*;
import static com.greennfc.tools.v14.GreenNfcFactory.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.greennfc.tools.api.IGreenIntentWrite;
import com.greennfc.tools.api.beans.GreenWriteBean;
import com.greennfc.tools.samples.R;

public class GreenWriteActivity //
		extends AbstractWriteActivity //
		implements IGreenIntentWrite //
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GREEN_NFC_MANAGER.register(this //
				, NDEF_FILTER //
				);

	}

	@SuppressWarnings("unchecked")
	@Override
	protected void onNewIntent(Intent intent) {
		/*
		 * Manadatory
		 */
		msg_feedback.setText(R.string.writing_tag);
		GREEN_NFC_MANAGER.writeTag(getApplicationContext(), //
				intent, //
				this, //
				true, // addAndroidApplicationRecord
				GreenWriteBean.writeBeanConfigure() //
						.writer(writer()) //
						.build());
	}

	/**
	 * 
	 * Green NFC methods
	 **/

	@Override
	public void messageWrite(boolean ok, Exception error) {
		msg_feedback.setText(ok ? R.string.tag_write : R.string.tag_not_write);
		if (!ok) {
			msg_feedback_error.setVisibility(View.VISIBLE);
			msg_feedback_error.setText(error.getMessage());
		}

	}

}
