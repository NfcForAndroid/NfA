package com.greennfc.tools.api;

import android.app.Activity;
import android.content.Intent;

import com.greennfc.tools.api.beans.GreenRecieveBean;

/**
 * @author jefBinomed
 * 
 */
public interface IGreenManager {

	/**
	 * Use this method when you want to register your activity to nfc intents and when you want to read the first intent launch at the start of your activity and when you want to use Beam mode (SNEP)
	 * 
	 * Recommand for read / beam nfc activity
	 * 
	 * @param activity
	 * @param recieveConfiguration
	 * @param filters
	 */
	<Record extends IGreenRecord> void register(Activity activity, GreenRecieveBean<Record> recieveConfiguration, IGreenBeam<Record> beamWriter, IGreenIntentFilter... filters);

	/**
	 * Use this method when you want to register your activity to nfc intents and when you want to read the first intent launch at the start of your activity
	 * 
	 * Recommand for read nfc activity
	 * 
	 * @param activity
	 * @param recieveConfiguration
	 * @param filters
	 */
	<Record extends IGreenRecord> void register(Activity activity, GreenRecieveBean<Record> recieveConfiguration, IGreenIntentFilter... filters);

	/**
	 * Use this method when you want to register your activity to nfc intents by specifying the filters and when you want to use beam mode (SNEP)
	 * 
	 * Recommand for write / beam nfc activity
	 * 
	 * @param activity
	 * @param filters
	 */
	<Record extends IGreenRecord> void register(Activity activity, IGreenBeam<Record> beamWriter, IGreenIntentFilter... filters);

	/**
	 * Use this method when you want to register your activity to nfc intents by specifying the filters
	 * 
	 * Recommand for write nfc activity
	 * 
	 * @param activity
	 * @param filters
	 */
	void register(Activity activity, IGreenIntentFilter... filters);

	/**
	 * Use this method when you want to use beam mode (SNEP)
	 * 
	 * Recommand for beam nfc activity
	 * 
	 * @param activity
	 * @param filters
	 */
	<Record extends IGreenRecord> void register(Activity activity, IGreenBeam<Record> beamWriter);

	void pause(Activity activity);

	void resume(Activity activity);

	void stop(Activity activity);

	<Record extends IGreenRecord> void manageIntent(GreenRecieveBean<Record> recieveConfiguration);

	<Record extends IGreenRecord> void writeTag(Intent intent, IGreenIntentWrite recieve, IGreenWriter<Record> writer, Record record);

}
