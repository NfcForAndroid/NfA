package com.nfa.tools.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.nfa.tools.api.beans.NfaRecieveBean;
import com.nfa.tools.api.beans.NfaWriteBean;

/**
 * @author jefBinomed
 * 
 */
public interface INfaManager {

	/**
	 * Use this method when you want to register your activity to nfc intents and when you want to read the first intent launch at the start of your activity and when you want to use Beam mode (SNEP)
	 * 
	 * Recommand for read / beam nfc activity
	 * 
	 * @param activity
	 * @param recieveConfiguration
	 * @param filters
	 */
	<Record extends INfaRecord> void register(Activity activity, NfaRecieveBean<Record> recieveConfiguration, INfaBeam<Record> beamWriter, INfaIntentFilter... filters);

	/**
	 * Use this method when you want to register your activity to nfc intents and when you want to read the first intent launch at the start of your activity
	 * 
	 * Recommand for read nfc activity
	 * 
	 * @param activity
	 * @param recieveConfiguration
	 * @param filters
	 */
	<Record extends INfaRecord> void register(Activity activity, NfaRecieveBean<Record> recieveConfiguration, INfaIntentFilter... filters);

	/**
	 * Use this method when you want to register your activity to nfc intents by specifying the filters and when you want to use beam mode (SNEP)
	 * 
	 * Recommand for write / beam nfc activity
	 * 
	 * @param activity
	 * @param filters
	 */
	<Record extends INfaRecord> void register(Activity activity, INfaBeam<Record> beamWriter, INfaIntentFilter... filters);

	/**
	 * Use this method when you want to register your activity to nfc intents by specifying the filters
	 * 
	 * Recommand for write nfc activity
	 * 
	 * @param activity
	 * @param filters
	 */
	void register(Activity activity, INfaIntentFilter... filters);

	/**
	 * Use this method when you want to use beam mode (SNEP)
	 * 
	 * Recommand for beam nfc activity
	 * 
	 * @param activity
	 * @param filters
	 */
	<Record extends INfaRecord> void register(Activity activity, INfaBeam<Record> beamWriter);

	void pause(Activity activity);

	void resume(Activity activity);

	void stop(Activity activity);

	<Record extends INfaRecord> void manageIntent(NfaRecieveBean<Record> recieveConfiguration);

	<Record extends INfaRecord> void writeTag(Context context, Intent intent, INfaIntentWrite recieve, boolean addAndroidApplicationRecord, NfaWriteBean<Record>... writers);

}
