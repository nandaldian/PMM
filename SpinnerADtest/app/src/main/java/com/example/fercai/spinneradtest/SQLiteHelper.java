package com.example.fercai.spinneradtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    //String sql1 = "create bla bla bla;";
    //String sql2 = "create foo bar;";
    //String[] statements = new String[]{sql1, sql2};
    // then
    //for(String sql : statements){
    //	database.execSQL(sql);
    //}
    String createUsers = "CREATE TABLE Clients IF NOT EXISTS (codigo INTEGER, nombre TEXT, telefono TEXT)";
    String createProducts="CREATE TABLE Products IF NOT EXISTS (codigo INTEGER, nombre TEXT, telefono TEXT)";

    public SQLiteHelper(Context context, String name,
                        CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createUsers);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

}