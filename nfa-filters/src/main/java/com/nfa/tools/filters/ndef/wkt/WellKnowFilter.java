package com.nfa.tools.filters.ndef.wkt;

import android.nfc.NfcAdapter;

import com.nfa.tools.api.INfaIntentFilter;
import com.nfa.tools.filters.base.NdefFilter;

/**
 * @author jefBinomed
 * 
 *         Class that represent a {@link INfaIntentFilter} for WellKnowType
 * 
 *         Action = {@link NfcAdapter#ACTION_NDEF_DISCOVERED}
 * 
 * 
 */
abstract class WellKnowFilter extends NdefFilter {

}
