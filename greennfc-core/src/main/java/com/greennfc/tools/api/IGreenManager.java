package com.greennfc.tools.api;

import android.app.Activity;
import android.content.Intent;

/**
 * @author jefBinomed
 * 
 */
public interface IGreenManager {

	void register(Activity activity, IGreenIntentFilter... filters);

	void pause(Activity activity);

	void resume(Activity activity);

	void manageIntent(Intent intent, IGreenIntentRecieve recieve, IGreenParser parser);

	<Record extends IGreenRecord> void writeTag(Intent intent, IGreenIntentWrite recieve, IGreenWriter<Record> writer, Record record);

}
