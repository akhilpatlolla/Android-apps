package edu.niu.cs.akhil.baking;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChocolateChipCookie extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chocolate_chip_cookie);
	}
	//Method to get back to previous intent
	public void goBack(View view){
		finish();
	}
}
