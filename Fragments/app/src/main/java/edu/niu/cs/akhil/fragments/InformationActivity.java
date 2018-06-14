package edu.niu.cs.akhil.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
			finish();
		}
		setContentView(R.layout.fragment_information);
		Intent intent = getIntent();
		String shadeInfo = intent.getStringExtra("Information");
		TextView infoTV  = (TextView) findViewById(R.id.colorInfo);
		infoTV.setText(shadeInfo);
		Button backbutton = (Button)findViewById(R.id.backButton);
		backbutton.setVisibility(View.VISIBLE);
	}
	public void goBack(View v){
		finish();
		v.setVisibility(View.INVISIBLE);
	}
}
