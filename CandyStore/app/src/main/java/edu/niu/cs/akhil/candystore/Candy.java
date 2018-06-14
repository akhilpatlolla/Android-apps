package edu.niu.cs.akhil.candystore;

/**
 * Created by akhil on 4/18/17.
 */


public class Candy
{
	private int id;
	private String name;
	private double price;

	public Candy(int newId, String newName, double newPrice)
	{
		id = newId;
		name = newName;
		price = newPrice;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int newId)
	{
		id = newId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String newName)
	{
		name = newName;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double newPrice)
	{
		price = newPrice;
	}

	public String toString()
	{
		return id + " " + name + " " + price;
	}


}




