package com.github.nfcforandroid.filters.ndef.wkt;

import android.nfc.NfcAdapter;

import com.github.nfcforandroid.api.INfaIntentFilter;
import com.github.nfcforandroid.filters.base.NdefFilter;

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
