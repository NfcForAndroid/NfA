package com.github.nfcforandroid.samples.game;

import static com.github.nfcforandroid.filters.factory.NfaFiltersFactory.*;
import static com.github.nfcforandroid.parser.factory.NfaParserFactory.*;
import static com.github.nfcforandroid.v14.NfaFactory.*;

import java.io.IOException;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.github.nfcforandroid.api.beans.NfaRecieveBean;
import com.github.nfcforandroid.api.beans.NfaRecieveBean.NfaRecieveBeanBuilder;
import com.github.nfcforandroid.api.client.INfaIntentRecieveRecord;
import com.github.nfcforandroid.records.ndef.ext.TextExternalRecord;
import com.github.nfcforandroid.samples.R;
import com.github.nfcforandroid.samples.cst.NfaSampleCst;

/**
 * @author jefBinomed Basic game where you have the choice between 2 animals and the tags are launching the sound of animals
 */
public class NfaGame extends SherlockActivity implements INfaIntentRecieveRecord<TextExternalRecord> //
		, OnTouchListener //
		, OnDragListener //
{

	ImageView tigerView, elephantView, targetView;
	TextView feedBack;

	Drawable enterShape, normalShape;

	int curentTagScan = -1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Ui initialisation
		setContentView(R.layout.activity_game);

		tigerView = (ImageView) findViewById(R.id.tiger);
		elephantView = (ImageView) findViewById(R.id.elephant);
		targetView = (ImageView) findViewById(R.id.target);
		feedBack = (TextView) findViewById(R.id.feedback_message);

		tigerView.setOnTouchListener(this);
		elephantView.setOnTouchListener(this);

		normalShape = getResources().getDrawable(R.drawable.shape);
		enterShape = getResources().getDrawable(R.drawable.shape_droptarget);
		targetView.setOnDragListener(this);

		// Nfa initialisation
		// We add a NfaRecieveBean in order to manage first intent
		NfaRecieveBeanBuilder<TextExternalRecord> recieverBuilder = NfaRecieveBean.recieveBeanConfigure();
		NFA_MANAGER.register(this // Activity
				, recieverBuilder //
						.intent(getIntent())//
						.intentRecieveRecord(this)//
						.parser(EXTERNAL_TEXT_PARSER)//
						.build()// NfaRecieveBean
				, externalFilters().textExternalNdefFilter(NfaSampleCst.TYPE_EXTERNAL_GAME)// Filter to use
				);
	}

	/**
	 * NFA Methods
	 **/
	@Override
	protected void onNewIntent(Intent intent) {
		NfaRecieveBeanBuilder<TextExternalRecord> recieverBuilder = NfaRecieveBean.recieveBeanConfigure();
		// We manage the record
		NFA_MANAGER.manageIntent(recieverBuilder //
				.intent(intent)//
				.intentRecieveRecord(this)//
				.parser(EXTERNAL_TEXT_PARSER)//
				.build()//
				);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.nfcforandroid.api.client.INfaIntentRecieveRecord#recieveRecord(com.github.nfcforandroid.api.INfaRecord)
	 */
	@Override
	public void recieveRecord(TextExternalRecord record) {
		// According to the datas, we start the correct sound
		if (String.valueOf(NfaSampleCst.VALUE_TIGER).equals(record.getMessage())) {
			reset();
			curentTagScan = NfaSampleCst.VALUE_TIGER;
			try {
				AssetFileDescriptor afd = getAssets().openFd("tiger.mp3");
				MediaPlayer player = new MediaPlayer();
				// player.setDataSource(afd.getFileDescriptor());
				player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
				player.prepare();
				player.start();
			} catch (IOException e) {
			}
		} else if (String.valueOf(NfaSampleCst.VALUE_ELEPHANT).equals(record.getMessage())) {
			reset();
			curentTagScan = NfaSampleCst.VALUE_ELEPHANT;
			try {
				AssetFileDescriptor afd = getAssets().openFd("elephant.mp3");
				MediaPlayer player = new MediaPlayer();
				// player.setDataSource(afd.getFileDescriptor());
				player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
				player.prepare();
				player.start();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * Drag and drop support
	 **/

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnTouchListener#onTouch(android.view.View, android.view.MotionEvent)
	 */
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			ClipData data = ClipData.newPlainText("", "");
			DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
			v.startDrag(data, shadowBuilder, v, 0);
			v.setVisibility(View.INVISIBLE);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnDragListener#onDrag(android.view.View, android.view.DragEvent)
	 */
	@Override
	public boolean onDrag(View v, DragEvent event) {
		switch (event.getAction()) {
		case DragEvent.ACTION_DRAG_STARTED:
			break;
		case DragEvent.ACTION_DRAG_ENTERED:
			v.setBackground(enterShape);
			break;
		case DragEvent.ACTION_DRAG_EXITED:
			v.setBackground(normalShape);

			break;
		case DragEvent.ACTION_DROP:
			View view = (View) event.getLocalState();
			if (curentTagScan == -1) {
				feedBack.setText(R.string.animal_no_tag);
			} else if ((curentTagScan == NfaSampleCst.VALUE_TIGER && view.getId() == R.id.tiger) || (curentTagScan == NfaSampleCst.VALUE_ELEPHANT && view.getId() == R.id.elephant)) {
				feedBack.setText(R.string.animal_found);
			} else {

				feedBack.setText(R.string.animal_not_found);
			}
			// view.setVisibility(View.VISIBLE);
			break;
		case DragEvent.ACTION_DRAG_ENDED:

			v.setBackground(curentTagScan == NfaSampleCst.VALUE_TIGER ? tigerView.getBackground() : elephantView.getBackground());

		default:
			break;
		}
		return true;
	}

	/**
	 * Action Bar management
	 **/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.activity_read_items, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.rescan_item:
			reset();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void reset() {
		curentTagScan = -1;
		feedBack.setText("");
		tigerView.setVisibility(View.VISIBLE);
		elephantView.setVisibility(View.VISIBLE);
		targetView.setBackground(normalShape);
	}
}
