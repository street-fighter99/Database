package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    public static  final String DATABASE_NAME="staudent.db";
    public static  final String TABLE_NAME="user_id";
    public static  final String COLO1="ID";
    public static  final String COLO2="USER";
    public static  final String COLO3="PASS";

    public DatabaseHelperClass(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+"("+COLO1 +" int(10) PRIMARY KEY AUTOINCREMENT ,"+COLO2+" varchar(10),"+COLO3+" varchar(10))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public void Insert(String username, String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        ContentValues.put(COLO2,username);
        ContentValues.put(COLO3,pass);


    }
}

