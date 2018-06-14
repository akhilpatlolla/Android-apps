package edu.niu.cs.akhil.flipcard;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAnswer(View v){
        Intent showAmswer = new Intent(MainActivity.this,AnswerActivity.class);
        startActivity(showAmswer);
        overridePendingTransition(R.anim.answer_on,R.anim.question_off);

    }

}
