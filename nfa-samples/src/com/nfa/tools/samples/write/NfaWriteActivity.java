package com.nfa.tools.samples.write;

import static com.nfa.tools.filters.factory.NfaFiltersFactory.*;
import static com.nfa.tools.v14.NfaFactory.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nfa.tools.api.beans.NfaWriteBean;
import com.nfa.tools.api.client.INfaIntentWrite;
import com.nfa.tools.samples.R;

public class NfaWriteActivity
		extends AbstractWriteActivity //
		implements INfaIntentWrite //
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
				check_android_record.isChecked(), // addAndroidApplicationRecord
				NfaWriteBean.writeBeanConfigure() //
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
