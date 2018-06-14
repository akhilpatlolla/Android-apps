package edu.niu.cs.akhil.candystore;

import android.content.Context;
import android.widget.Button;

/**
 * Created by akhil on 4/25/17.
 */
public class CandyButton extends Button
{
	private Candy candy;

	public CandyButton(Context context, Candy newCandy)
	{
		super(context);
		candy = newCandy;
	}

	public double getPrice()
	{
		return candy.getPrice();
	}
}
