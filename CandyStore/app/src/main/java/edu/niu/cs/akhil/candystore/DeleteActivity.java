package edu.niu.cs.akhil.candystore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
public class DeleteActivity extends AppCompatActivity
{
	private DatabaseManager database;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		database = new DatabaseManager(this);

		updateView();
	}//end onCreate

	public void updateView()
	{
		ArrayList<Candy> candies = database.selectAll();

		RelativeLayout relativeLayout = new RelativeLayout(this);

		ScrollView scrollView = new ScrollView(this);

		RadioGroup radioGroup = new RadioGroup(this);

		//fill the radio group with the information from the database
		for( Candy candy : candies )
		{
			//create an individual radio button
			RadioButton radioButton = new RadioButton(this);

			//set the id and text for the radio button
			radioButton.setId(candy.getId());
			radioButton.setText(candy.toString());

			//add the radio button to the radio group
			radioGroup.addView(radioButton);
		}

		//handle selection in radio group
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(RadioGroup radioGroup, int checkedID)
			{
				database.deleteByID( checkedID );
				Toast.makeText(DeleteActivity.this, "Deleted candy", Toast.LENGTH_SHORT).show();
				updateView();
			}
		});

		Button backBtn = new Button(this);

		backBtn.setText(R.string.backString);

		backBtn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				finish();
			}
		});

		//put the radiogroup in the scrollview
		scrollView.addView(radioGroup);

		//put the scrollview in the relative layout
		relativeLayout.addView(scrollView);

		//set up parameters to make back button be at the bottom of the screen
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params.addRule(RelativeLayout.CENTER_HORIZONTAL);

		params.setMargins(0,0,0, 50);

		//add the button to the relative layout using the parameters
		relativeLayout.addView(backBtn, params);

		//put the relative layout on the screen
		setContentView(relativeLayout);
	}//end updateView

}//end of class
