package com.github.nfcforandroid.v14;

import static com.github.nfcforandroid.v9.NfaFactory.*;
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

import com.github.nfcforandroid.api.INfaIntentFilter;
import com.github.nfcforandroid.api.INfaManager;
import com.github.nfcforandroid.api.INfaRecord;
import com.github.nfcforandroid.api.beans.NfaRecieveBean;
import com.github.nfcforandroid.api.beans.NfaWriteBean;
import com.github.nfcforandroid.api.client.INfaBeam;
import com.github.nfcforandroid.api.client.INfaIntentWrite;
import com.github.nfcforandroid.records.factory.NfaRecordFactory;
import com.github.nfcforandroid.writers.factory.NfaWriterFactory;

/**
 * @author jefBinomed
 * 
 *         {@link INfaManager} implementation for android v14 or higher
 */
class NfaManagerV14 implements INfaManager, ActivityLifecycleCallbacks {

	protected NfaManagerV14() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaManager#register(android.app.Activity, com.github.nfcforandroid.api.INfaIntentFilter[])
	 */
	public void register(Activity activity, INfaIntentFilter... filters) {
		register(activity, null, null, filters);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaManager#register(android.app.Activity, com.github.nfcforandroid.api.beans.NfaRecieveBean, com.github.nfcforandroid.api.client.INfaBeam, com.github.nfcforandroid.api.INfaIntentFilter[])
	 */
	public <Record extends INfaRecord> void register(final Activity activity, NfaRecieveBean<Record> recieveConfiguration, final INfaBeam<Record> beamWriter, INfaIntentFilter... filters) {
		// We user the v9 as reference because all that is done in v9 could be applicable to higher version
		NFA_MANAGER.register(activity, recieveConfiguration, filters);
		// We check if we're searching to do some beam
		if (beamWriter != null) {
			// We have to get an instance of the global nfcAdapter
			NfcAdapter mAdapter = NfcAdapter.getDefaultAdapter(activity);
			// We check that there is some writers define before trying to write
			assert beamWriter.getWriters() != null && beamWriter.getWriters().size() > 0 : "You have to specify at least one INfaWriter if you want to beam messages !";

			// We define the beam callback mecanism
			mAdapter.setOnNdefPushCompleteCallback(new OnNdefPushCompleteCallback() {

				public void onNdefPushComplete(NfcEvent event) {
					// We call the callback to specify that the beam was well done
					beamWriter.beamCallBack();

				}
			}, activity);

			// We register to beam intent
			mAdapter.setNdefPushMessageCallback(new CreateNdefMessageCallback() {

				public NdefMessage createNdefMessage(NfcEvent event) {
					// We have to create the NdefMessage
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
		// We just check the version in order to avoid compatibility problem
		assert Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH : "You can not use this method with a previous version of android sdk";
		// We observe the lifecyle of the application in order to manage the call of specifics methods
		activity.getApplication().registerActivityLifecycleCallbacks(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaManager#register(android.app.Activity, com.github.nfcforandroid.api.client.INfaBeam, com.github.nfcforandroid.api.INfaIntentFilter[])
	 */
	public <Record extends INfaRecord> void register(Activity activity, INfaBeam<Record> beamWriter, INfaIntentFilter... filters) {
		register(activity, null, beamWriter, filters);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaManager#register(android.app.Activity, com.github.nfcforandroid.api.client.INfaBeam)
	 */
	public <Record extends INfaRecord> void register(Activity activity, INfaBeam<Record> beamWriter) {
		register(activity, null, beamWriter);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaManager#register(android.app.Activity, com.github.nfcforandroid.api.beans.NfaRecieveBean, com.github.nfcforandroid.api.INfaIntentFilter[])
	 */
	public <Record extends INfaRecord> void register(Activity activity, NfaRecieveBean<Record> recieveConfig, INfaIntentFilter... greenfilters) {
		register(activity, recieveConfig, null, greenfilters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaManager#pause(android.app.Activity)
	 */
	public void pause(Activity activity) {
		NFA_MANAGER.pause(activity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaManager#resume(android.app.Activity)
	 */
	public void resume(Activity activity) {
		NFA_MANAGER.resume(activity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaManager#stop(android.app.Activity)
	 */
	public void stop(Activity activity) {
		NFA_MANAGER.stop(activity);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaManager#manageIntent(com.github.nfcforandroid.api.beans.NfaRecieveBean)
	 */
	public <Record extends INfaRecord> void manageIntent(NfaRecieveBean<Record> recieveConfig) {
		NFA_MANAGER.manageIntent(recieveConfig);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.INfaManager#writeTag(android.content.Context, android.content.Intent, com.github.nfcforandroid.api.client.INfaIntentWrite, boolean, com.github.nfcforandroid.api.beans.NfaWriteBean<Record>[])
	 */
	public <Record extends INfaRecord> void writeTag(final Context context, final Intent intent, final INfaIntentWrite recieve, final boolean addAndroidApplicationRecord, final NfaWriteBean<Record>... writers) {
		NFA_MANAGER.writeTag(context, intent, recieve, addAndroidApplicationRecord, writers);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application.ActivityLifecycleCallbacks#onActivityCreated(android.app.Activity, android.os.Bundle)
	 */
	public void onActivityCreated(Activity activity, Bundle bundle) {
		// Nothing to do

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application.ActivityLifecycleCallbacks#onActivityDestroyed(android.app.Activity)
	 */
	public void onActivityDestroyed(Activity activity) {
		activity.getApplication().unregisterActivityLifecycleCallbacks(this);
		stop(activity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application.ActivityLifecycleCallbacks#onActivityPaused(android.app.Activity)
	 */
	public void onActivityPaused(Activity activity) {
		pause(activity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application.ActivityLifecycleCallbacks#onActivityResumed(android.app.Activity)
	 */
	public void onActivityResumed(Activity activity) {
		resume(activity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application.ActivityLifecycleCallbacks#onActivitySaveInstanceState(android.app.Activity, android.os.Bundle)
	 */
	public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
		// nothing to do

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application.ActivityLifecycleCallbacks#onActivityStarted(android.app.Activity)
	 */
	public void onActivityStarted(Activity activity) {
		// nothing to do

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application.ActivityLifecycleCallbacks#onActivityStopped(android.app.Activity)
	 */
	public void onActivityStopped(Activity activity) {
		// nothing to do

	}

}
