package edu.niu.cs.akhil.candystore;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/**
 * Created by akhil on 4/18/17.
 */

public class DatabaseManager extends SQLiteOpenHelper
{
	private static final String DATABASE_NAME = "candydb";

	private static final int DATABASE_VERSION = 1;

	private static final String TABLE_CANDY = "candy",
			ID = "id",
			NAME = "name",
			PRICE = "price";

	public DatabaseManager(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase)
	{
		//build SQL statement
		String sqlCreate = "create table " + TABLE_CANDY + "( " +
				ID + " integer primary key autoincrement, " +
				NAME + " text, " +
				PRICE + " real )";

		sqLiteDatabase.execSQL(sqlCreate);
	}//end of onCreate

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
	{
		sqLiteDatabase.execSQL("drop table if exists " + TABLE_CANDY);
		onCreate(sqLiteDatabase);
	}//end of onUpgrade

	public void insert( Candy candy )
	{
		SQLiteDatabase database = getWritableDatabase();

		String sqlInsert = "insert into " + TABLE_CANDY +
				" values( null, '" + candy.getName() +
				"', '" + candy.getPrice() + "' )";

		database.execSQL(sqlInsert);
		database.close();
	}//end of insert

	public void deleteByID( int id )
	{
		SQLiteDatabase database = getWritableDatabase();

		String sqlDelete = "delete from " + TABLE_CANDY +
				" where " + ID + " = " + id;

		database.execSQL(sqlDelete);
		database.close();
	}//end of deleteByID

	public void updateByID( int id, String name, double price)
	{
		String sqlUpdate = "update " + TABLE_CANDY +
				" set " + NAME + " = '" + name + "', " +
				PRICE + " = '" + price + "'" +
				" where " + ID + " = " + id;
		SQLiteDatabase database = getWritableDatabase();

		database.execSQL(sqlUpdate);
		database.close();
	}

	public ArrayList<Candy> selectAll()
	{
		String sqlSelect = "select * from " + TABLE_CANDY;

		SQLiteDatabase database = getWritableDatabase();

		Cursor cursor = database.rawQuery(sqlSelect, null);

		ArrayList<Candy> candies = new ArrayList<>();

		while (cursor.moveToNext())
		{
			Candy currentCandy = new Candy( Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), cursor.getDouble(2));
			candies.add(currentCandy);
		}

		database.close();
		return candies;
	}

	public Candy selectByID( int id )
	{
		String sqlSelect = "select * from " + TABLE_CANDY +
				" where " + ID + " = " + id;

		SQLiteDatabase database = getWritableDatabase();

		Cursor cursor = database.rawQuery(sqlSelect, null);

		Candy candy = null;

		if( cursor.moveToFirst() )
		{
			candy = new Candy(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
					cursor.getDouble(2));
		}
		database.close();
		return  candy;
	}

}//end of class





