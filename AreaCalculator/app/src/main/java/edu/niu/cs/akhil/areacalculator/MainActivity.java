package edu.niu.cs.akhil.areacalculator;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private int flag=0;
    TextView areaTV;
    Button getInfo;
    RadioGroup shape;
    static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        areaTV = (TextView) findViewById(R.id.areaTextView);
        getInfo = (Button) findViewById(R.id.infoButton);
        shape = (RadioGroup) findViewById(R.id.shapeRadioGroup);
        shape.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.circleRadioButton:flag=2;break;
                    case R.id.triangleRadioButton:flag=1;break;

                    case R.id.ellipseRadioButton:flag=3;break;

                }
            }
        });
    }

    public void doCalc(View view) {
        if (shape.getCheckedRadioButtonId() == -1){
            Toast.makeText(view.getContext(),"Check one shape",Toast.LENGTH_LONG).show();
            return;

        }
        Intent areaIntern;
        if (flag == 1) {
            areaIntern = new Intent(MainActivity.this, Triangle.class);
            startActivityForResult(areaIntern, REQUEST_CODE);
        }else if (flag == 2) {
            areaIntern = new Intent(MainActivity.this, Circle.class);
            startActivityForResult( areaIntern, REQUEST_CODE  );

        }else if( flag == 3) {
            areaIntern = new Intent(MainActivity.this, Ellipse.class);
            startActivityForResult( areaIntern, REQUEST_CODE  );

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String s1,s2;
        Double area;
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            if (flag == 1) {
                s1 = data.getStringExtra("firstField");
                s2 = data.getStringExtra("secondField");
                area = 0.5 * Double.parseDouble(s1) * Double.parseDouble(s2);
                areaTV.setText(String.format("Area of Triangle is %.3f",area));
            }else if (flag == 2) {
                s1 = data.getStringExtra("firstField");
                area = Math.PI * Double.parseDouble(s1) * Double.parseDouble(s1);
                areaTV.setText(String.format("Area of Circle is %.3f",area));
            }else{
                s1 = data.getStringExtra("firstField");
                s2 = data.getStringExtra("secondField");
                area = Math.PI * Double.parseDouble(s1) * Double.parseDouble(s2);
                areaTV.setText(String.format("Area of Ellipse is %.3f",area));
            }
        }
    }
}

