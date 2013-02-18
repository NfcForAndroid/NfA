package com.greennfc.tools.v14;

import static com.greennfc.tools.v9.GreenNfcFactory.*;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.CreateNdefMessageCallback;
import android.nfc.NfcAdapter.OnNdefPushCompleteCallback;
import android.nfc.NfcEvent;
import android.os.Build;
import android.os.Bundle;

import com.greennfc.tools.api.IGreenBeam;
import com.greennfc.tools.api.IGreenIntentFilter;
import com.greennfc.tools.api.IGreenIntentWrite;
import com.greennfc.tools.api.IGreenManager;
import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.beans.GreenRecieveBean;
import com.greennfc.tools.api.beans.GreenWriteBean;

class GreenManagerV14 implements IGreenManager, ActivityLifecycleCallbacks {

	protected GreenManagerV14() {
		super();
	}

	public void register(Activity activity, IGreenIntentFilter... filters) {
		register(activity, null, null, filters);

	}

	public <Record extends IGreenRecord> void register(Activity activity, GreenRecieveBean<Record> recieveConfiguration, final IGreenBeam<Record> beamWriter, IGreenIntentFilter... filters) {
		GREEN_NFC_MANAGER.register(activity, recieveConfiguration, filters);
		if (beamWriter != null) {
			NfcAdapter mAdapter = NfcAdapter.getDefaultAdapter(activity);
			assert beamWriter.getWriters() != null && beamWriter.getWriters().size() > 0 : "You have to specify at least one IGreenWriter if you want to beam messages !";

			mAdapter.setOnNdefPushCompleteCallback(new OnNdefPushCompleteCallback() {

				public void onNdefPushComplete(NfcEvent arg0) {
					beamWriter.beamCallBack();

				}
			}, activity);
			mAdapter.setNdefPushMessageCallback(new CreateNdefMessageCallback() {

				public NdefMessage createNdefMessage(NfcEvent event) {
					NdefRecord[] recordArray = new NdefRecord[beamWriter.getWriters().size()];
					int i = 0;
					for (GreenWriteBean<Record> writer : beamWriter.getWriters()) {
						if (!writer.getGreenWriter().isInit()) {
							writer.getGreenWriter().init(writer.getGreenRecord());
						}
						recordArray[i] = writer.getGreenWriter().getNdefRecord();
						if (writer.isForceReinit()) {
							writer.getGreenWriter().reset();
						}
						i++;
					}
					return new NdefMessage(recordArray);
				}
			}, activity);
		}
		assert Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH : "You can not use this method with a previous version of android sdk";
		activity.getApplication().registerActivityLifecycleCallbacks(this);
	}

	public <Record extends IGreenRecord> void register(Activity activity, IGreenBeam<Record> beamWriter, IGreenIntentFilter... filters) {
		register(activity, null, beamWriter, filters);

	}

	public <Record extends IGreenRecord> void register(Activity activity, IGreenBeam<Record> beamWriter) {
		register(activity, null, beamWriter);

	}

	public <Record extends IGreenRecord> void register(Activity activity, GreenRecieveBean<Record> recieveConfig, IGreenIntentFilter... greenfilters) {
		register(activity, recieveConfig, null, greenfilters);
	}

	public void pause(Activity activity) {
		GREEN_NFC_MANAGER.pause(activity);
	}

	public void resume(Activity activity) {
		GREEN_NFC_MANAGER.resume(activity);
	}

	public void stop(Activity activity) {
		GREEN_NFC_MANAGER.stop(activity);

	}

	public <Record extends IGreenRecord> void manageIntent(GreenRecieveBean<Record> recieveConfig) {
		GREEN_NFC_MANAGER.manageIntent(recieveConfig);
	}

	public <Record extends IGreenRecord> void writeTag(final Intent intent, final IGreenIntentWrite recieve, final GreenWriteBean<Record>... writers) {
		GREEN_NFC_MANAGER.writeTag(intent, recieve, writers);
	}

	public void onActivityCreated(Activity activity, Bundle bundle) {
		// Nothing to do

	}

	public void onActivityDestroyed(Activity activity) {
		activity.getApplication().unregisterActivityLifecycleCallbacks(this);
		stop(activity);
	}

	public void onActivityPaused(Activity activity) {
		pause(activity);
	}

	public void onActivityResumed(Activity activity) {
		resume(activity);
	}

	public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
		// nothing to do

	}

	public void onActivityStarted(Activity activity) {
		// nothing to do

	}

	public void onActivityStopped(Activity activity) {
		// nothing to do

	}

}
