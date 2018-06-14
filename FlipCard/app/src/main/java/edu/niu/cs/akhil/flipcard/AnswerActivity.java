package edu.niu.cs.akhil.flipcard;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnswerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
    }
    public void goQuestion(View v){
        finish();
        overridePendingTransition(R.anim.question_on,R.anim.question_off);
    }
}
