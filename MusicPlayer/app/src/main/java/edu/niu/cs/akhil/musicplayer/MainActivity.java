package edu.niu.cs.akhil.musicplayer;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends ListActivity {

    private final static String TAG = "MP3",PATH = "/storage/emulated/0/Music/";
    private Button pausePlayBttn, stopBtn;
    private TextView songnameTV;
    private List<String > songs;
    private MediaPlayer player;

    //new String (Environment.getExternalStorageDirectory().toString()+ "/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songs = new ArrayList<>();
        player = new MediaPlayer();

        updatePlayList();

        songnameTV = (TextView)findViewById(R.id.textView);

        pausePlayBttn = (Button) findViewById(R.id.pauseButton);
        pausePlayBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if media player is playing
                if (player.isPlaying()){
                    player.pause();
                    pausePlayBttn.setBackgroundResource(R.drawable.play);
                }
                else{
                    player.start();
                    pausePlayBttn.setBackgroundResource(R.drawable.pause);
                }
            }
        });
        stopBtn = (Button)findViewById(R.id.stopButton);
        stopBtn.setOnClickListener(stopListener);
    }
    private View.OnClickListener stopListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            player.stop();
            songnameTV.setVisibility(View.INVISIBLE);
            pausePlayBttn.setBackgroundResource(R.drawable.pause);
            pausePlayBttn.setVisibility(View.INVISIBLE);
            stopBtn.setVisibility(View.INVISIBLE);
        }
    };
    public void updatePlayList(){

        //all into array of file objects
        File [] mp3Files= (new File(PATH)).listFiles(new MP3Filter());

        if(mp3Files.length > 0){
            for ( File file : mp3Files){
                songs.add(file.getName());
            }
        }
        ArrayAdapter<String> songsList = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,songs);
        setListAdapter(songsList);
    }

    class MP3Filter implements FilenameFilter{
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".mp3");
        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        try {
            player.reset();
            player.setDataSource(PATH + songs.get(position));
            player.prepare();
            player.start();
            songnameTV.setText("Song : " + songs.get(position));
            songnameTV.setVisibility(View.VISIBLE);
            //pause and play
            pausePlayBttn.setBackgroundResource(R.drawable.pause);
            pausePlayBttn.setVisibility(View.VISIBLE);
            stopBtn.setBackgroundResource(R.drawable.stop);
            stopBtn.setVisibility(View.VISIBLE);
        }
        catch ( IOException e){
            Log.d("TAG",e.getMessage());
        }
    }
}
