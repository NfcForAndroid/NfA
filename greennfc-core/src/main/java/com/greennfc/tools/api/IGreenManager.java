package com.greennfc.tools.api;

import android.app.Activity;
import android.content.Intent;

import com.greennfc.tools.api.beans.GreenRecieveBean;

/**
 * @author jefBinomed
 * 
 */
public interface IGreenManager {

	<Record extends IGreenRecord> void register(Activity activity, GreenRecieveBean<Record> recieveConfiguration, IGreenIntentFilter... filters);

	void register(Activity activity, IGreenIntentFilter... filters);

	void pause(Activity activity);

	void resume(Activity activity);

	void stop(Activity activity);

	<Record extends IGreenRecord> void manageIntent(GreenRecieveBean<Record> recieveConfiguration);

	<Record extends IGreenRecord> void writeTag(Intent intent, IGreenIntentWrite recieve, IGreenWriter<Record> writer, Record record);

}
