package com.cmos.happyweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
	/*
	 * Province表建表语句
	 */
	public static final String CREATE_PROVINCE = "create table Province(id integer primary key autoincrement,"
			+ "province_name text,province_code text)";
	/*
	 * City表建表语句
	 */
	public static final String CREATE_CITY = "create table City(id integer primary key autoincrement,city_name text,"
			+ "city_code text,province_id integer) ";
	/*
	 * Country表建表语句
	 */
	public static final String CREATE_COUNTRY = "create table Country(id integer primary key autoincrement,country_name text,"
			+ "country_code text,city_id integer)";

	public MyDbHelper(Context context, String name, CursorFactory factory,
					  int version) {
		super(context, name, factory, version);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自动生成的方法存根
		db.execSQL(CREATE_PROVINCE);
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_COUNTRY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自动生成的方法存根

	}

}
