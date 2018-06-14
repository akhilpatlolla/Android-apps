package edu.niu.cs.akhil.shippingcalculator;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;

public class HelpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
	}

	public void goback(View view){
		finish();
	}
}
