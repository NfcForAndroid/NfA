package com.greennfc.tools.api;

import android.app.Activity;
import android.content.Intent;

/**
 * @author jefBinomed
 * 
 */
public interface IGreenManager {

	void register(Activity activity);

	void initIntent(IGreenIntentFilter... filters);

	void pause(Activity activity);

	void resume(Activity activity);

	void manageIntent(Intent intent);

}
