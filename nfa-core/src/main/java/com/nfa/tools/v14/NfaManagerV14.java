package com.nfa.tools.v14;

import static com.nfa.tools.v9.NfaFactory.*;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.CreateNdefMessageCallback;
import android.nfc.NfcAdapter.OnNdefPushCompleteCallback;
import android.nfc.NfcEvent;
import android.os.Build;
import android.os.Bundle;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.api.INfaManager;
import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.beans.NfaRecieveBean;
import com.nfa.tools.api.beans.NfaWriteBean;
import com.nfa.tools.api.client.INfaBeam;
import com.nfa.tools.api.client.INfaIntentWrite;
import com.nfa.tools.records.factory.NfaRecordFactory;
import com.nfa.tools.writers.factory.NfaWriterFactory;

class NfaManagerV14 implements INfaManager, ActivityLifecycleCallbacks {

	protected NfaManagerV14() {
		super();
	}

	public void register(Activity activity, INfaIntentFilter... filters) {
		register(activity, null, null, filters);

	}

	public <Record extends INfaRecord> void register(final Activity activity, NfaRecieveBean<Record> recieveConfiguration, final INfaBeam<Record> beamWriter, INfaIntentFilter... filters) {
		GREEN_NFC_MANAGER.register(activity, recieveConfiguration, filters);
		if (beamWriter != null) {
			NfcAdapter mAdapter = NfcAdapter.getDefaultAdapter(activity);
			assert beamWriter.getWriters() != null && beamWriter.getWriters().size() > 0 : "You have to specify at least one IGreenWriter if you want to beam messages !";

			mAdapter.setOnNdefPushCompleteCallback(new OnNdefPushCompleteCallback() {

				public void onNdefPushComplete(NfcEvent event) {
					beamWriter.beamCallBack();

				}
			}, activity);
			mAdapter.setNdefPushMessageCallback(new CreateNdefMessageCallback() {

				public NdefMessage createNdefMessage(NfcEvent event) {
					NdefRecord[] recordArray = new NdefRecord[beamWriter.getWriters().size() + (beamWriter.addAndroidApplicationRecord() ? 1 : 0)];
					int i = 0;
					for (NfaWriteBean<Record> writer : beamWriter.getWriters()) {
						if (!writer.getNfaWriter().isInit()) {
							writer.getNfaWriter().init(writer.getNfaRecord());
						}
						recordArray[i] = writer.getNfaWriter().getNdefRecord();
						if (writer.isForceReinit()) {
							writer.getNfaWriter().reset();
						}
						i++;
					}
					if (beamWriter.addAndroidApplicationRecord()) {
						NfaWriterFactory.ANDROID_APPLICATION_WRITER.init(NfaRecordFactory.externalFactory().androidApplicationRecordInstance(activity));
						recordArray[i] = NfaWriterFactory.ANDROID_APPLICATION_WRITER.getNdefRecord();
						NfaWriterFactory.ANDROID_APPLICATION_WRITER.reset();
					}
					return new NdefMessage(recordArray);
				}
			}, activity);
		}
		assert Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH : "You can not use this method with a previous version of android sdk";
		activity.getApplication().registerActivityLifecycleCallbacks(this);
	}

	public <Record extends INfaRecord> void register(Activity activity, INfaBeam<Record> beamWriter, INfaIntentFilter... filters) {
		register(activity, null, beamWriter, filters);

	}

	public <Record extends INfaRecord> void register(Activity activity, INfaBeam<Record> beamWriter) {
		register(activity, null, beamWriter);

	}

	public <Record extends INfaRecord> void register(Activity activity, NfaRecieveBean<Record> recieveConfig, INfaIntentFilter... greenfilters) {
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

	public <Record extends INfaRecord> void manageIntent(NfaRecieveBean<Record> recieveConfig) {
		GREEN_NFC_MANAGER.manageIntent(recieveConfig);
	}

	public <Record extends INfaRecord> void writeTag(final Context context, final Intent intent, final INfaIntentWrite recieve, final boolean addAndroidApplicationRecord, final NfaWriteBean<Record>... writers) {
		GREEN_NFC_MANAGER.writeTag(context, intent, recieve, addAndroidApplicationRecord, writers);
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
