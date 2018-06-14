package edu.niu.cs.akhil.implicit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView pictureIV;

	static final int REQUEST_CODE = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pictureIV = (ImageView)findViewById(R.id.pictureImageView);
	}

	public void doBrowser(View view){
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/akhilpatlolla/"));
		startActivity(browserIntent);
	}
	public void doPhone(View view){
		Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+917416170747"));
		startActivity(phoneIntent);
	}
	public void doCamera(View view){
		Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if( cameraIntent.resolveActivity( getPackageManager()) != null)
		startActivityForResult(cameraIntent,REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (REQUEST_CODE == requestCode && RESULT_OK == resultCode ){
			Bundle extras = data.getExtras();
			Bitmap picture = (Bitmap)extras.get("data");
			pictureIV.setImageBitmap(picture);
		}
	}
}
