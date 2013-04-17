package com.nfa.tools.api.client;

import java.util.List;

import com.nfa.tools.api.INfaRecord;
import com.nfa.tools.api.beans.NfaWriteBean;

/**
 * @author jefBinomed
 * 
 *         Interface which defines the methods to use for using beam protocol
 * 
 *         This interface is to use when you want to do beam communication.
 * 
 * @see NfaWriteBean
 * @see INfaIntentWrite
 * 
 * @param <Record>
 *            the type of record to passed through beam
 */
public interface INfaBeam<Record extends INfaRecord> {

	/**
	 * Gives the list of {@link NfaWriteBean} used for writing datas, you could
	 * 
	 * This method is called when the beam action is being initiate by android framework
	 * 
	 * @return a list of {@link NfaWriteBean}, an empty list if no writers are available
	 */
	List<NfaWriteBean<Record>> getWriters();

	/**
	 * This method tells to the client that the beam action was welled finish. This method is called when the beam transfert is finish
	 */
	void beamCallBack();

	/**
	 * @return <code>true</code> if you want to add the AndroidApplicationRecord to your Ndef message. <code>false</code> else.
	 */
	boolean addAndroidApplicationRecord();

}
