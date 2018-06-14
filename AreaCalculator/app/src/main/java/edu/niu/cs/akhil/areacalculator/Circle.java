package edu.niu.cs.akhil.areacalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Circle extends Activity {
    private EditText radiusET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        radiusET = (EditText)findViewById(R.id.radus);
    }
    public void circleBack(View view){
        if (radiusET.getText().toString().matches("")){
            Toast.makeText(view.getContext(),"Please Enter Values", Toast.LENGTH_LONG).show();
            return;
        }
        String radius;
        radius = radiusET.getText().toString();
        Intent intent;
        intent = getIntent();
        intent.putExtra("firstField",radius);
        ((Activity) view.getContext()).setResult(RESULT_OK,intent);
        finish();
    }
}
