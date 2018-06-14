package edu.niu.cs.akhil.assignment0;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView firstText;Button click;boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect the variables with view objects
        firstText = (TextView) findViewById(R.id.firstTextView);
        click = (Button) findViewById(R.id.click);
        flag = true;
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    firstText.setText(R.string.secondText);
                    flag=false;
                }else{
                    firstText.setText(R.string.firstText);
                    flag=true;
                }
            }
        });
    }
}