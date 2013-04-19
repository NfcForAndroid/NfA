package com.github.nfcforandroid.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;

import com.github.nfcforandroid.api.beans.NfaRecieveBean;
import com.github.nfcforandroid.api.beans.NfaWriteBean;
import com.github.nfcforandroid.api.client.INfaBeam;
import com.github.nfcforandroid.api.client.INfaIntentWrite;

/**
 * @author jefBinomed
 * 
 *         Main interface that drives the interactions between your {@link Activity} and the nfc android features.
 * 
 *         Two implementations are write in the nfa-core module.
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

	/**
	 * You should call this method when the activity enter in {@link Activity#onPause()}.
	 * 
	 * This call is mandatory because it's the guaranty of the unregistration of your application against the {@link NfcAdapter}
	 * 
	 * @param activity
	 *            the activity you will unregister
	 */
	void pause(Activity activity);

	/**
	 * You should call this method when the activity enter in {@link Activity#onResume()}.
	 * 
	 * This call is mandatory because it's the guaranty of the registration of your application against the {@link NfcAdapter}
	 * 
	 * During this call, all the filters you have previously define will be add to the {@link NfcAdapter}
	 * 
	 * @param activity
	 *            the activity you will register
	 */
	void resume(Activity activity);

	/**
	 * You should call this method when the activity enter in {@link Activity#onStop()}.
	 * 
	 * This call is mandatory because it's the guaranty of the clean of all your filters
	 * 
	 * @param activity
	 *            the activity you will clean
	 */
	void stop(Activity activity);

	/**
	 * This method is to call when a tag or message is detect by the android framework.
	 * 
	 * You will call this method in the {@link Activity#onNewIntent()} method or during the first creation of your activity to process the first Intent.
	 * 
	 * This method will process the tag to convert it into something more readable / treatable according to your {@link NfaRecieveBean} configuration
	 * 
	 * @param recieveConfiguration
	 *            the configuration to use to convert the enter tag message
	 */
	<Record extends INfaRecord> void manageIntent(NfaRecieveBean<Record> recieveConfiguration);

	/**
	 * 
	 * This method is to call when you want to write some datas on a tag.
	 * 
	 * You will call this method in the {@link Activity#onNewIntent()} method
	 * 
	 * This method will convert your data to an {@link NdefMessage} and write it on the detect tag
	 * 
	 * @param context
	 *            the curent {@link Context}. Could not be <code>null</code>.
	 * @param intent
	 *            the intent at the origin of the call (You have to use the intent of onNewIntent because it contains the mandatory information to identify the tag). Could not be <code>null</code>.
	 * @param recieve
	 *            the callBack interface. could not be <code>null</code>.
	 * @param addAndroidApplicationRecord
	 *            <code>true</code> if you want to integrate an AndroidApplicationRecord. <code>false</code> else.
	 * @param writers
	 *            a collection of bean configuration to write the datas you need. You should have at least one {@link NfaWriteBean} !
	 */
	<Record extends INfaRecord> void writeTag(Context context, Intent intent, INfaIntentWrite recieve, boolean addAndroidApplicationRecord, NfaWriteBean<Record>... writers);

}
