package edu.niu.cs.akhil.splashscreen;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button guitarBtn,drumsBtn;
    private MediaPlayer guitarMP, drumsMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guitarBtn = (Button)findViewById(R.id.guitarid);
        drumsBtn = (Button)findViewById(R.id.drumsid);
        guitarMP = new MediaPlayer();
        drumsMP = new MediaPlayer();
        guitarMP = MediaPlayer.create(this,R.raw.ukulele);
        drumsMP = MediaPlayer.create(this,R.raw.drums);

    }

    public void playGuitar(View view){
        if ( guitarMP.isPlaying() ){
            guitarMP.pause();
            ((Button)view).setText(R.string.playGuitarString);

        }else{
            if (drumsMP.isPlaying()){
                drumsMP.pause();
                ((Button)view).setText(R.string.playDrumsString);
            }
            guitarMP.start();
            ((Button)view).setText(R.string.pauseGuitarString);
        }
    }

    public void playDrums(View view){
        if ( drumsMP.isPlaying() ){
            drumsMP.pause();
            ((Button)view).setText(R.string.playDrumsString);

        }else{
            if (guitarMP.isPlaying()){
                guitarMP.pause();
                ((Button)view).setText(R.string.playGuitarString);
            }
            drumsMP.start();
            ((Button)view).setText(R.string.pauseDrumsString);
        }
    }
}
