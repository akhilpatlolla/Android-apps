package edu.niu.cs.akhil.baking;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Brownies extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brownies);
	}

	//Method to get back to previous intent
	public void goBack(View view){
		finish();
	}
}
