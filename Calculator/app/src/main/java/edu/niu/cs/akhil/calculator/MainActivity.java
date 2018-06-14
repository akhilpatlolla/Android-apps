package edu.niu.cs.akhil.calculator;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText et1,et2;   TextView op;   Float n1,n2,rel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        op  = (TextView)findViewById(R.id.op);

        Button plus,minus,multi,divi;
        plus = (Button)findViewById(R.id.addition);
        minus = (Button)findViewById(R.id.subtract);
        multi = (Button)findViewById(R.id.multiplication);
        divi = (Button)findViewById(R.id.division);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().matches("") || et2.getText().toString().matches(""))
                {
                    Toast.makeText(v.getContext(), "Common Man Enter Values Dont be dumb :p", Toast.LENGTH_LONG).show();
                    return;
                }
                n1  = Float.parseFloat(et1.getText().toString());                n2  = Float.parseFloat(et2.getText().toString());
                rel = n1 +  n2;
                op.setText(rel.toString());
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().matches("") || et2.getText().toString().matches(""))
                {
                    Toast.makeText(v.getContext(), "Common Man Enter Values Dont be dumb :p", Toast.LENGTH_LONG).show();
                    return;
                }
                n1  = Float.parseFloat(et1.getText().toString());                n2  = Float.parseFloat(et2.getText().toString());
                rel = n1 -  n2;
                op.setText(rel.toString());
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().matches("") || et2.getText().toString().matches(""))
                {
                    Toast.makeText(v.getContext(), "Common Man Enter Values Dont be dumb :p", Toast.LENGTH_LONG).show();
                    return;
                }
                n1  = Float.parseFloat(et1.getText().toString());                n2  = Float.parseFloat(et2.getText().toString());
                rel = n1 *  n2;
                op.setText(rel.toString());
            }
        });
        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().matches("") || et2.getText().toString().matches(""))
                {
                    Toast.makeText(v.getContext(), "Common Man Enter Values Dont be dumb :p", Toast.LENGTH_LONG).show();
                    return;
                }
                if (et2.getText().toString().matches("0"))
                {
                    Toast.makeText(v.getContext(), "Denominator cant be 0 you idiot :P ", Toast.LENGTH_LONG).show();
                    return;
                }
                n1  = Float.parseFloat(et1.getText().toString());                n2  = Float.parseFloat(et2.getText().toString());
                rel = n1 /  n2;
                op.setText(rel.toString());
            }
        });
        Button clearbtn = (Button)findViewById(R.id.delete);
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(""); et2.setText(""); op.setText("");
            }
        });
    }

}
