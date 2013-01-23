package com.greennfc.tools.api;

import android.app.Activity;
import android.content.Intent;

/**
 * @author jefBinomed
 * 
 */
public interface IGreenManager<Record extends IGreenRecord> {

	void register(IGreenIntentRecieve<Record> activity, IGreenParser parser, IGreenIntentFilter... filters);

	void pause(Activity activity);

	void resume(Activity activity);

	void manageIntent(Intent intent);

}
