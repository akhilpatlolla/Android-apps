package edu.niu.cs.akhil.candystore;

import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReadWriteLock;


public class UpdateActivity extends AppCompatActivity
{
	private DatabaseManager databaseManager;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		databaseManager = new DatabaseManager(this);
		updateView();
	}

	public void updateView()
	{
		//Get all of the items in the database
		ArrayList<Candy> candies = databaseManager.selectAll();

		int numCandies = candies.size();

		//if there are candies in the database
		if( numCandies > 0 )
		{
			RelativeLayout layout = new RelativeLayout(this);  //parent layout

			ScrollView scrollView = new ScrollView(this);  //to hold lots of data

			GridLayout gridLayout = new GridLayout(this);
			gridLayout.setRowCount(numCandies);
			gridLayout.setColumnCount(4);

			TextView [] ids = new TextView[numCandies];
			EditText[][] namesAndPrices = new EditText[numCandies][2];
			Button [] buttons = new Button[numCandies];

			//find the screen width
			Point size = new Point();
			getWindowManager().getDefaultDisplay().getSize(size);
			int width = size.x;

			int sub = 0;

			for( Candy candy : candies )
			{
				//fill the textview with an id
				ids[sub] = new TextView(this);
				ids[sub].setGravity(Gravity.CENTER);
				ids[sub].setText( "" + candy.getId()  );

				//fill the edit text fields
				namesAndPrices[sub][0] = new EditText(this);
				namesAndPrices[sub][1] = new EditText(this);

				namesAndPrices[sub][0].setText(candy.getName());
				namesAndPrices[sub][1].setText("" + candy.getPrice());

				namesAndPrices[sub][1].setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);

				namesAndPrices[sub][0].setId(10 * candy.getId());
				namesAndPrices[sub][1].setId(10 * candy.getId() + 1);

				//fill the button fields
				buttons[sub] = new Button(this);

				buttons[sub].setText("Update");
				buttons[sub].setId(candy.getId());
				buttons[sub].setOnClickListener(buttonHandler);

				gridLayout.addView(ids[sub], width/10, ViewGroup.LayoutParams.WRAP_CONTENT);
				gridLayout.addView(namesAndPrices[sub][0], (int)(width * .4), ViewGroup.LayoutParams.WRAP_CONTENT);
				gridLayout.addView(namesAndPrices[sub][1], (int)(width * .15), ViewGroup.LayoutParams.WRAP_CONTENT);
				gridLayout.addView(buttons[sub], (int)(width * .35), ViewGroup.LayoutParams.WRAP_CONTENT);

				sub++;
			}//end of for

			Button backButton = new Button(this);
			backButton.setText(R.string.backString);
			backButton.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					finish();
				}
			});

			//start to buld the overall layout
			//add the gridlayout to the scrollview
			scrollView.addView(gridLayout);

			//add the scrollview to the relative layout
			layout.addView(scrollView);

			//set up parameters for the back button to make sure it's at the bottom of the screen
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			params.addRule(RelativeLayout.CENTER_HORIZONTAL);

			params.setMargins(0,0,0,50);

			//add the back button to the relative layout using the parameters
			layout.addView(backButton, params);


			//Display the relative layout
			setContentView(layout);
		}//end if
	}//end updateView

	//onClickListener for the button
	public View.OnClickListener buttonHandler = new View.OnClickListener()
	{
		@Override
		public void onClick(View view)
		{
			int candyID = view.getId();

			EditText nameET = (EditText)findViewById( 10 * candyID  ),
					priceET = (EditText)findViewById( 10 * candyID + 1);

			String nameStr = nameET.getText().toString(),
					priceStr = priceET.getText().toString();
			try
			{
				double price = Double.parseDouble(priceStr);

				databaseManager.updateByID(candyID, nameStr, price);

				Toast.makeText(UpdateActivity.this, "Candy updated: " + nameStr, Toast.LENGTH_SHORT).show();
				updateView();
			}
			catch(NumberFormatException nfe)
			{
				Toast.makeText(UpdateActivity.this, "Candy NOT updated: price error", Toast.LENGTH_SHORT).show();
			}
		}
	};









}