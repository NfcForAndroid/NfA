package com.greennfc.tools.samples.write;

import static com.greennfc.tools.v14.GreenNfcFactory.*;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;

import com.greennfc.tools.api.IGreenBeam;
import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.beans.GreenWriteBean;
import com.greennfc.tools.samples.R;

public class GreenBeamActivity //
		extends AbstractWriteActivity //
		implements IGreenBeam<IGreenRecord> //
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
	public List<GreenWriteBean<IGreenRecord>> getWriters() {
		return Arrays.asList(GreenWriteBean.writeBeanConfigure() //
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
