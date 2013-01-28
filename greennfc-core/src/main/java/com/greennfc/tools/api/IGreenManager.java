package com.greennfc.tools.api;

import android.app.Activity;
import android.content.Intent;

/**
 * @author jefBinomed
 * 
 */
public interface IGreenManager<Record extends IGreenRecord> {

	void register(Activity activity, IGreenIntentFilter... filters);

	void pause(Activity activity);

	void resume(Activity activity);

	void manageIntent(Intent intent, IGreenIntentRecieve<Record> recieve, IGreenParser parser);

	void writeTag(Intent intent, IGreenWriter writer, Record record);

}
