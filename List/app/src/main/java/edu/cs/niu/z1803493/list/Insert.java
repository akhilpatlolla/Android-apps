/*
Name:  Patlolla Akhil Reddy
Zid : z1803493
filename : Insert.java
 */
package edu.cs.niu.z1803493.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Insert extends AppCompatActivity {
    private DatbaseManager database;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        database = new DatbaseManager(this);
        scrollView = (ScrollView)findViewById(R.id.listScrollView);
       // updateView();
    }

    public void insert(View view){
        EditText nameET = (EditText) findViewById(R.id.itemNameEditText);
        String nameStr = nameET.getText().toString();
        Item candy = new Item(0, nameStr);
        database.insert(candy);
        Toast.makeText(this, "List Item added: " + nameStr, Toast.LENGTH_SHORT).show();
        nameET.setText("");
        //updateView();
    }//end of insert

        public void updateView(){
            ArrayList<Item> items= database.selectAll();
            int numItems = items.size();
            if(numItems > 0) {
            try{
                scrollView.removeAllViewsInLayout();
            }catch (NullPointerException e){
                e.printStackTrace();
            }
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                for (Item item : items) {
                    TextView TV = new CheckBox(getApplicationContext());
                    TV.setText(TV.getText()+ "\n"+item.getName());
                    linearLayout.addView(TV);
                }//end for
                scrollView.addView(linearLayout);
            }
        }
    public void goBack(View view){finish();}
}
