package edu.niu.cs.akhil.candystore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class insert extends AppCompatActivity {

	private DatabaseManager database;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert);
		database = new DatabaseManager(this);
	}//end onCreate

	public void insert(View view)
	{
		EditText nameET = (EditText) findViewById(R.id.candyNameEditText),
				priceET = (EditText)findViewById(R.id.candyPriceEditText);

		String nameStr = nameET.getText().toString(),
				priceStr = priceET.getText().toString();

		try
		{
			double price = Double.parseDouble(priceStr);
			Candy candy = new Candy(0, nameStr, price);

			database.insert(candy);
			Toast.makeText(this, "Candy added: " + nameStr, Toast.LENGTH_SHORT).show();
		}
		catch(NumberFormatException nfe)
		{
			Toast.makeText(this, "Price error", Toast.LENGTH_SHORT).show();
		}

		nameET.setText("");
		priceET.setText("");
	}//end of insert

	public void goBack(View view)
	{
		finish();
	}
}
