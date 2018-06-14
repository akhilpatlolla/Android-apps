package edu.niu.cs.akhil.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private Spinner heroSpin,osSpin,courseSpin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heroSpin = (Spinner)findViewById(R.id.favHero);

        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(getApplicationContext(),R.array.heroNames,R.layout.spinner_main);
        heroSpin.setAdapter(adapter1);

        heroSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selecHero;
                selecHero = parent.getItemAtPosition( position ).toString();
                Toast.makeText(getApplicationContext(),"Daaaam !! Your Favorite Hero is "+ selecHero,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        osSpin = (Spinner) findViewById(R.id.favOs);

        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_main,SpinnerInfo.valueArray);

        osSpin.setAdapter(adapter2);
        osSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String osSelection;
                osSelection = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Daaaam !! Your Favorite OS is "+ osSelection,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<String> values = new ArrayList<>();
        values.add("CSCI 522 Android Application Development");
        values.add("CSCI 688 Database Concepts");
        values.add("CSCI 680 MSTR Topics in Computer Science - BIG DATA ANALYTICS ");
        courseSpin = (Spinner)findViewById(R.id.favCourse);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_main,values);

        courseSpin.setAdapter(adapter3);
        courseSpin.setOnItemSelectedListener(spinnerListener);
    }

    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String courseSelection;
            courseSelection = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),"Daaaam !! Your Favorite Course is "+ courseSelection,Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
