package edu.niu.cs.akhil.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        };
        Timer opening = new Timer();
        opening.schedule(task,5000);
    }
}
