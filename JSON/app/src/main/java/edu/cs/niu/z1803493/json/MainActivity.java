package edu.cs.niu.z1803493.json;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<State> stateList = new ArrayList<>();
    private StateArrayAdapter stateArrayAdapter;
    private ListView stateLV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stateLV = (ListView)findViewById(R.id.stateListView);
        stateArrayAdapter = new StateArrayAdapter(this,stateList);
        stateLV.setAdapter(stateArrayAdapter);
    }

    public void getData(View view){
        String urlString = getString(R.string.web_url);
        try{
            URL url = new URL(urlString);
            StateTask stateTask = new StateTask();
            stateTask.execute(url);
        }catch (Exception e){
                e.printStackTrace();
        }
    }
    private void convertJSONtoArrayList(JSONObject states){
        stateList.clear();
        try{
            JSONArray list=  states.getJSONArray("places");
            for (int index = 0;index<list.length();index++){
                    JSONObject stateObj = list.getJSONObject(index);
                stateList.add(new State(stateObj.getString("Place"),stateObj.getInt("Number")));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    private class StateTask extends AsyncTask <URL,String,JSONObject> {
        public StateTask() {}

        @Override
        protected void onProgressUpdate(String... values) {
            Toast.makeText(MainActivity.this,values[0],Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            convertJSONtoArrayList(jsonObject);
            stateArrayAdapter.notifyDataSetChanged();
            stateLV.smoothScrollToPosition(0);
        }

        @Override
        protected JSONObject doInBackground(URL... urls) {
            HttpURLConnection connection = null;
            try{
                connection = (HttpURLConnection)urls[0].openConnection();
                int response=  connection.getResponseCode();
                if (response == HttpURLConnection.HTTP_OK){
                    StringBuilder builder = new StringBuilder();
                    try{
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String line;
                        while( (line = reader.readLine()) != null ){
                                builder.append(line);
                        }
                    }catch (IOException ioe){
                        ioe.printStackTrace();
                        publishProgress("Read Error");
                    }
                    return new JSONObject(builder.toString());
                }else{
                    publishProgress("Bad URL");
                }
            }catch (Exception e){
                e.printStackTrace();
                publishProgress("Bad JSON Object");
            }finally {
                connection.disconnect();
            }
            return null;
        }

    }


}
