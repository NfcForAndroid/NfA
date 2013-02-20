package com.greennfc.tools.samples.write;

import static com.greennfc.tools.records.factory.GreenRecordFactory.*;
import static com.greennfc.tools.writers.factory.GreenWriterFactory.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.greennfc.tools.api.IGreenRecord;
import com.greennfc.tools.api.IGreenWriter;
import com.greennfc.tools.records.factory.GreenRecordFactory;
import com.greennfc.tools.records.ndef.wkt.SmartPosterRecordDatas;
import com.greennfc.tools.samples.R;

abstract class AbstractWriteActivity extends SherlockFragmentActivity {

	protected TextView msg_feedback, msg_feedback_error;
	protected Spinner type_tag, uri_prefix;
	protected EditText tag_content, content_bis;
	protected ImageView content_img;

	protected static final int TAG_EMPTY = 0;
	protected static final int TAG_TEXT = 1;
	protected static final int TAG_URI = 2;
	protected static final int TAG_SMART_POSTER = 3;
	protected static final int TAG_IMAGE = 4;

	private static final int MEDIA_TYPE_IMAGE = 1;
	private static final int CAPTURE_IMAGE_REQUEST_CODE = 100;
	private static final int IMAGE_CROP_REQUEST_CODE = 200;

	private static SimpleDateFormat TIME_STAMP_FORMAT = new SimpleDateFormat("yyyyMMdd_HHmmss");

	private Uri imageFileUri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write);

		msg_feedback = (TextView) findViewById(R.id.msg_feedback);
		msg_feedback_error = (TextView) findViewById(R.id.msg_feedback_error);
		type_tag = (Spinner) findViewById(R.id.spinnerType);
		uri_prefix = (Spinner) findViewById(R.id.uri_prefix);
		tag_content = (EditText) findViewById(R.id.tag_content);
		content_bis = (EditText) findViewById(R.id.content_bis);
		content_img = (ImageView) findViewById(R.id.content_img);
		tag_content.setEnabled(false);
		uri_prefix.setVisibility(View.GONE);
		content_bis.setVisibility(View.GONE);
		content_img.setVisibility(View.GONE);
		msg_feedback_error.setVisibility(View.GONE);

		type_tag.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> root, View view, int pos, long arg3) {
				switch (pos) {
				case TAG_EMPTY:
					tag_content.setEnabled(false);
					tag_content.setHint("");
					content_bis.setVisibility(View.GONE);
					uri_prefix.setVisibility(View.GONE);
					content_img.setVisibility(View.GONE);
					break;
				case TAG_TEXT:
					tag_content.setEnabled(true);
					tag_content.setHint(R.string.type_text);
					content_bis.setVisibility(View.GONE);
					uri_prefix.setVisibility(View.GONE);
					content_img.setVisibility(View.GONE);
					break;
				case TAG_URI:
					tag_content.setEnabled(true);
					tag_content.setHint(R.string.type_uri);
					content_bis.setVisibility(View.GONE);
					uri_prefix.setVisibility(View.VISIBLE);
					content_img.setVisibility(View.GONE);
					break;
				case TAG_SMART_POSTER:
					tag_content.setEnabled(true);
					tag_content.setHint(R.string.type_uri);
					content_bis.setVisibility(View.VISIBLE);
					uri_prefix.setVisibility(View.VISIBLE);
					content_img.setVisibility(View.GONE);
					break;
				case TAG_IMAGE:
					tag_content.setEnabled(false);
					tag_content.setHint(R.string.hint_image);
					content_bis.setVisibility(View.GONE);
					uri_prefix.setVisibility(View.GONE);
					content_img.setVisibility(View.VISIBLE);
					break;

				default:
					break;
				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		content_img.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				imageFileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

				intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);

				startActivityForResult(intentCamera, CAPTURE_IMAGE_REQUEST_CODE);
			}
		});

	}

	@SuppressWarnings("unchecked")
	protected <Record extends IGreenRecord> IGreenWriter<Record> writer() {
		IGreenWriter<Record> writer = null;
		Record record = null;
		switch (type_tag.getSelectedItemPosition()) {
		case TAG_EMPTY: {
			writer = (IGreenWriter<Record>) EMPTY_WRITER;
			record = (Record) EMPTY_RECORD;
			break;
		}
		case TAG_TEXT: {
			writer = (IGreenWriter<Record>) TEXT_WRITER;
			record = (Record) GreenRecordFactory.wellKnowTypeFactory().textRecordInstance(tag_content.getText().toString());
			break;
		}
		case TAG_URI: {
			writer = (IGreenWriter<Record>) URI_WRITER;
			String uriPrefix = this.uri_prefix.getSelectedItem().toString();
			String uri = uriPrefix.length() > 0 ? uriPrefix + tag_content.getText().toString() : tag_content.getText().toString();
			record = (Record) GreenRecordFactory.wellKnowTypeFactory().uriRecordInstance(uri);

			break;
		}
		case TAG_SMART_POSTER: {
			writer = (IGreenWriter<Record>) SMART_POSTER_WRITER;
			String uriSmartPoster = tag_content.getText().toString();
			String titleSmartPoster = content_bis.getText().toString();
			String uriPrefix = this.uri_prefix.getSelectedItem().toString();
			String uri = uriPrefix.length() > 0 ? uriPrefix + uriSmartPoster : uriSmartPoster;
			record = (Record) GreenRecordFactory.wellKnowTypeFactory().smartPosterRecordInstance( //
					SmartPosterRecordDatas.instance() //
							.uri(GreenRecordFactory.wellKnowTypeFactory().uriRecordInstance(uri)) //
							.title(GreenRecordFactory.wellKnowTypeFactory().textRecordInstance(titleSmartPoster)) //
							.build()//
					);

			break;
		}
		case TAG_IMAGE: {
			writer = (IGreenWriter<Record>) MIME_TYPE_WRITER;
			Bitmap imageBitmap = ((BitmapDrawable) content_img.getDrawable()).getBitmap();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			imageBitmap.compress(CompressFormat.JPEG, 40, os);
			try {
				os.close();
				record = (Record) GreenRecordFactory.ndefFactory().mimeRecordInstance("image/jpeg", os.toByteArray());
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}

			break;
		}
		default:
			break;
		}
		writer.init(record);
		return writer;

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
			msg_feedback.setText(R.string.wating_tag);
			msg_feedback_error.setVisibility(View.GONE);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/**
	 * 
	 * IMAGE Management
	 * 
	 **/

	private Uri getOutputMediaFileUri(int type) {
		return Uri.fromFile(getOutputMediaFile(type));
	}

	private File getOutputMediaFile(int type) {
		File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "GreenNfcSample");

		if (!mediaStorageDir.exists()) {
			if (!mediaStorageDir.mkdirs()) {
				return null;
			}
		}

		String timeStamp = TIME_STAMP_FORMAT.format(new Date());
		File mediaFile = null;
		if (type == MEDIA_TYPE_IMAGE) {
			mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
		} else {
			return null;
		}

		return mediaFile;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAPTURE_IMAGE_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				Intent intentCrop = new Intent("com.android.camera.action.CROP");
				intentCrop.setDataAndType(imageFileUri, "image/*");
				intentCrop.putExtra("crop", true);
				intentCrop.putExtra("aspectX", 1);
				intentCrop.putExtra("aspectY", 1);
				intentCrop.putExtra("outputX", 150);
				intentCrop.putExtra("outputY", 150);
				intentCrop.putExtra("scale", 10);
				intentCrop.putExtra("return-data", true);
				startActivityForResult(intentCrop, IMAGE_CROP_REQUEST_CODE);
			}
		}
		if (requestCode == IMAGE_CROP_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				Bundle extras = data.getExtras();

				Bitmap picture = extras.getParcelable("data");
				content_img.setImageBitmap(picture);
			}
		}
	}

}
