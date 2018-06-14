package edu.niu.cs.akhil.shippingcalculator;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity {

    ShipItem item;
    EditText weightInput;
    TextView baseCost,addedCost,totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightInput = (EditText)findViewById(R.id.weightEditText);
        baseCost = (TextView) findViewById(R.id.baseTextView);
        addedCost = (TextView)findViewById(R.id.addedTextView);
        totalCost = (TextView)findViewById(R.id.totalTextView);
        item = new ShipItem();
        weightInput.requestFocus();
        weightInput.addTextChangedListener(weightWatcher);

    }



    TextWatcher weightWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                item.setWeight(Double.parseDouble(s.toString()));
            }
            catch ( NumberFormatException e){
                item.setWeight(0.0);
            }

            java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");

            baseCost.setText("$"+df.format(item.getBasecost()));
            addedCost.setText("$"+df.format(item.getAddedcost()));
            totalCost.setText("$"+df.format(item.getTotalcost()));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void getHelp(View view){
        Intent helpIntent = new Intent(MainActivity.this,HelpActivity.class);
        startActivity(helpIntent);
    }
}
