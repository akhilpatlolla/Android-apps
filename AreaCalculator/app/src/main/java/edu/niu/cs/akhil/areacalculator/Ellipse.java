package edu.niu.cs.akhil.areacalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static edu.niu.cs.akhil.areacalculator.R.id.semimajor;
import static edu.niu.cs.akhil.areacalculator.R.id.semiminor;

public class Ellipse extends Activity {
    private EditText semimajorET,semiminorET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellipse);
        semimajorET = (EditText)findViewById(semimajor);
        semiminorET = (EditText)findViewById(semiminor);
    }
    public void ellipseBack(View view){

        String semimajor,semiminor;
        if (semimajorET.getText().toString().matches("")||semiminorET.getText().toString().matches("")){
            Toast.makeText(view.getContext(),"Please Enter Values", Toast.LENGTH_LONG).show();
            return;
        }
        semimajor = semimajorET.getText().toString();
        semiminor = semiminorET.getText().toString();
        Intent intent;
        intent = getIntent();
        intent.putExtra("firstField",semimajor);
        intent.putExtra("secondField",semiminor);
        ((Activity) view.getContext()).setResult(RESULT_OK,intent);
        finish();
    }
}
