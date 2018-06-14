/**
 * Name :  Assignment2
 * Author : Akhil Reddy Patlolla
 * zid : z1803493
 * Course  : CSCI 522 Android App development
 * Deadline : Feb 24th 2017
 * Purpose : Implement spinner along with image view and new intent with srolable text
 */
package edu.niu.cs.akhil.baking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;



public class MainActivity extends Activity {
	private Spinner pic_choice;
	private ImageView show_item;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//refernece to the spinner
		pic_choice = (Spinner) findViewById(R.id.choice);
		//creating adapter for spinner
		ArrayAdapter<String> adapter= new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_main,SpinnerInfo.valueArray);
		//setting the adapter to the spinner
		pic_choice.setAdapter(adapter);
		//assign functionality to the spinner
		pic_choice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				int choice = parent.getSelectedItemPosition();
				//reference to iamge view
				show_item = (ImageView)findViewById(R.id.item_image);

				switch (choice){
					case 0:
						//changes and updating the image view
						show_item.setImageResource(R.drawable.pic1);
						break;
					case 1:
						//changes and updating the image view
						show_item.setImageResource(R.drawable.pic2);
						break;
					case 2:
						//changes and updating the image view
						show_item.setImageResource(R.drawable.pic3);
						break;
					case 3:
						//changes and updating the image view
						show_item.setImageResource(R.drawable.pic4);
						break;
					case 4:
						//changes and updating the image view
						show_item.setImageResource(R.drawable.pic5);
						break;
				}

			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});


	}
	public void goRecipe(View view){
		int call_choice = pic_choice.getSelectedItemPosition();//status of the spinner
		//switch to pull on specific action for item
		switch (call_choice){
			case 0 ://chocolate cake case
				Intent target = new Intent(MainActivity.this,ChocolateCake.class);
				startActivity(target);
				break;
			case 1 ://chocolate chip case
				target = new Intent(MainActivity.this,ChocolateChipCookie.class);
				startActivity(target);
				break;
			case 2 ://chocolate pie case
				 target = new Intent(MainActivity.this,ChocolatePie.class);
				startActivity(target);
				break;
			case 3 ://brownies case
				 target = new Intent(MainActivity.this,Brownies.class);
				startActivity(target);
				break;
			case 4 ://chocolate ice cream case
				 target = new Intent(MainActivity.this,ChocolateIceCream.class);
				startActivity(target);
				break;

		}

	}

}
