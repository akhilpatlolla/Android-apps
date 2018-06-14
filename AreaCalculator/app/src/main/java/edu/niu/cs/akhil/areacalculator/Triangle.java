package edu.niu.cs.akhil.areacalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Triangle extends Activity {
    private EditText baseET;
    private EditText heightET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
        baseET = (EditText)findViewById(R.id.base);
        heightET = (EditText)findViewById(R.id.height);
    }
    public void goBack(View view){
        if (baseET.getText().toString().matches("")||heightET.getText().toString().matches("")){
            Toast.makeText(view.getContext(),"Please Enter Values", Toast.LENGTH_LONG).show();
            return;
        }
        String base,height;
        base = baseET.getText().toString();
        height = heightET.getText().toString();
        Intent intent;
        intent = getIntent();
        intent.putExtra("firstField",base);
        intent.putExtra("secondField",height);
        ((Activity) view.getContext()).setResult(RESULT_OK,intent);
        finish();
    }
}
