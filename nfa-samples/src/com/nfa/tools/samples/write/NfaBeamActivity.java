package com.nfa.tools.samples.write;

import static com.nfa.tools.v14.NfaFactory.*;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.beans.NfaWriteBean;
import com.nfa.tools.api.client.INfaBeam;
import com.nfa.tools.samples.R;

public class NfaBeamActivity
		extends AbstractWriteActivity //
		implements INfaBeam<INfaRecord> //
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		GREEN_NFC_MANAGER.register(this //
				, this //
				);

	}

	/**
	 * 
	 * Green NFC methods
	 **/

	@SuppressWarnings("unchecked")
	@Override
	public List<NfaWriteBean<INfaRecord>> getWriters() {
		return Arrays.asList(NfaWriteBean.writeBeanConfigure() //
				.writer(writer()) //
				.build());
	}

	@Override
	public void beamCallBack() {
		msg_feedback.setText(R.string.tag_write);

	}

	@Override
	public boolean addAndroidApplicationRecord() {
		return check_android_record.isChecked();
	}

}
