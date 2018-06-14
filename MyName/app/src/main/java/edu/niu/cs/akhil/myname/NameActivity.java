package edu.niu.cs.akhil.myname;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends Activity {

	private EditText nameET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name);
		nameET = (EditText)findViewById(R.id.name);
	}

	public void goBack(View view){

		String nameInput;
		nameInput = nameET.getText().toString();
		Intent intent;
		intent = getIntent();
		intent.putExtra("nameID",nameInput);
		((Activity) view.getContext()).setResult(RESULT_OK,intent);
		finish();
	}

}
