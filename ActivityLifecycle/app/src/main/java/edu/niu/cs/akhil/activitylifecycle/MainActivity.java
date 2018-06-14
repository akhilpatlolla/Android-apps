package edu.niu.cs.akhil.activitylifecycle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String createMsg, startMsg, resumeMsg, pauseMsg, stopMsg, restartMsg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createMsg = (String)getResources().getText(R.string.createMsg);
		startMsg = (String)getResources().getText(R.string.startMsg);
		resumeMsg = (String)getResources().getText(R.string.resumeMsg);
		pauseMsg = (String)getResources().getText(R.string.pauseMsg);
		stopMsg = (String)getResources().getText(R.string.stopMsg);
		restartMsg = (String)getResources().getText(R.string.restartMsg);

		Toast.makeText(this,createMsg,Toast.LENGTH_LONG).show();
		Log.d("MainActivity",createMsg);
	}

	@Override
	protected void onStart() {
		super.onStart();

		Toast.makeText(this,startMsg,Toast.LENGTH_LONG).show();
		Log.d("MainActivity",startMsg);

	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(this,restartMsg,Toast.LENGTH_LONG).show();
		Log.d("MainActivity",restartMsg);

	}

	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(this,resumeMsg,Toast.LENGTH_LONG).show();
		Log.d("MainActivity",resumeMsg);

	}

	@Override
	protected void onPause() {
		super.onPause();
		Toast.makeText(this,pauseMsg,Toast.LENGTH_LONG).show();
		Log.d("MainActivity",pauseMsg);

	}

	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(this,stopMsg,Toast.LENGTH_LONG).show();
		Log.d("MainActivity",stopMsg);

	}
}
