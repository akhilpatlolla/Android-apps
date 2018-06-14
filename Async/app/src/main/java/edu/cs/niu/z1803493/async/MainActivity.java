package edu.cs.niu.z1803493.async;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button dowloadButton;
    private ProgressBar dowloadPB;
    private TextView dowloadProgressTV, callbackTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dowloadButton = (Button)findViewById(R.id.dowloadButton);
        dowloadPB = (ProgressBar)findViewById(R.id.dowloadProgressBar);
        dowloadProgressTV = (TextView)findViewById(R.id.downloadTextView);
        callbackTV = (TextView)findViewById(R.id.callbackTextView);
    }
    public void clearDisplay(View v){
        callbackTV.setText(" ");
    }
    public void startDownload(View view ){
        dowloadButton.setEnabled(false);
        new PerformAsyncTask().execute();
    }

    // inner Async
    private class PerformAsyncTask extends AsyncTask<Void, Integer,Void >{
        int progressStatus;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Lock the phones Orientation
            int currentOrientation = getResources().getConfiguration().orientation;
            if( currentOrientation == Configuration.ORIENTATION_PORTRAIT){
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
            else{
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }

            callbackTV.setText(callbackTV.getText()+ "\n \n >>> Orientation Locked <<< ");
            callbackTV.setText(callbackTV.getText()+ "\n \n <<< Invoked onPreExecuted Method >>>");
            progressStatus = 0;
            dowloadProgressTV.setText("Download 0% ");
            callbackTV.setText(callbackTV.getText()+"\n>>> Finished up On Pre Execute <<<");
            callbackTV.setText(callbackTV.getText()+"\n\n<<< Invoked doInBackgound >>>");
            callbackTV.setText(callbackTV.getText()+"\n\n<>< Preforming Background Work ><>");
        }

        @Override
        protected Void doInBackground(Void... params) {
            while(progressStatus < 100){
                progressStatus += 2;
                publishProgress(progressStatus);
                SystemClock.sleep(500);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            dowloadPB.setProgress(values[0]);
            dowloadProgressTV.setText("Dowload "+values[0]+" %");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            callbackTV.setText(callbackTV.getText()+"\n\n<<< Completed Background Work >>>");
            callbackTV.setText(callbackTV.getText()+"\n\n>>> Inovked Post Execute <<<");

            dowloadProgressTV.setText("Dowload Completed");
            dowloadButton.setEnabled(true);
        }
    }
}











