/*
Name:  Patlolla Akhil Reddy
Zid : z1803493
filename : SplashActivity.java
 */
package edu.cs.niu.z1803493.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Akhil on 5/4/2017.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
