package com.github.nfcforandroid.samples.write;

import static com.github.nfcforandroid.v14.NfaFactory.*;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;

import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.api.beans.NfaWriteBean;
import com.github.nfcforandroid.api.client.INfaBeam;
import com.github.nfcforandroid.samples.R;

public class NfaBeamActivity extends AbstractWriteActivity //
		implements INfaBeam<INfaRecord> //
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		NFA_MANAGER.register(this //
				, this //
				);

	}

	/**
	 * 
	 * NfA methods
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
