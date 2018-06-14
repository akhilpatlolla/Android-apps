package edu.niu.z1803493.threadcounter;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView countTv;
    private Integer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countTv = (TextView)findViewById(R.id.counterTextView);
        counter = 0;
        //create thread and associate with runnable
        Thread counterThread = new Thread(countRunnable);
        counterThread.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        counter = 0;
    }
    private Runnable countRunnable = new Runnable() {
        private static final int Delay = 1000;
        @Override
        public void run() {
            while(true){
                counter++;
                try{
                    Thread.sleep(Delay);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                threadHandler.sendEmptyMessage(0);
            }
        }
    };
    public Handler threadHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            countTv.setText(counter.toString());
        }
    };
}

