package edu.cs.niu.z1803493.animateddial;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Thread animatedThread;
    private DialView dialView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialView = new DialView(this);
        setContentView(dialView);

        animatedThread = new Thread(animationRunnable);

        animatedThread.start();
    }

    private Runnable animationRunnable = new Runnable() {
        private static final int DELAY =  1;
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(DELAY);
                    threadHandler.sendEmptyMessage(0);
                }
                catch (InterruptedException e){
                        e.printStackTrace();
                }
            }
        }
    };
    public Handler threadHandler  = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            dialView.update();
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        //remove messages that have been sent
        threadHandler.removeCallbacks(animationRunnable);
    }
}
