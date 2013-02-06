package com.greennfc.tools.v14;

import static com.greennfc.tools.v9.GreenNfcFactory.*;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.greennfc.tools.api.IGreenIntentFilter;
import com.greennfc.tools.api.IGreenIntentWrite;
import com.greennfc.tools.api.IGreenManager;
import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.api.beans.GreenRecieveBean;

class GreenManagerV14 implements IGreenManager, ActivityLifecycleCallbacks {

	private static final String TAG = "GreenManagerV14";

	protected GreenManagerV14() {
		super();
	}

	public void register(Activity activity, IGreenIntentFilter... filters) {
		register(activity, null, filters);

	}

	public <Record extends IGreenRecord> void register(Activity activity, GreenRecieveBean<Record> recieveConfig, IGreenIntentFilter... greenfilters) {
		GREEN_NFC_MANAGER.register(activity, recieveConfig, greenfilters);
		assert Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH : "You can not use this method with a previous version of android sdk";
		activity.getApplication().registerActivityLifecycleCallbacks(this);
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

	public <Record extends IGreenRecord> void writeTag(final Intent intent, final IGreenIntentWrite recieve, final IGreenWriter<Record> writer, final Record record) {
		GREEN_NFC_MANAGER.writeTag(intent, recieve, writer, record);
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
