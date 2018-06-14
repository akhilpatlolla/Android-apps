package edu.niu.cs.akhil.baking;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChocolateCake extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chocolate_cake);
	}
	//Method to get back to previous intent
	public void goBack(View view){
		finish();
	}

}
