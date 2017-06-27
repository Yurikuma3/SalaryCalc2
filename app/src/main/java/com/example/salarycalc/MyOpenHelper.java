package com.example.salarycalc;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyOpenHelper extends SQLiteOpenHelper {

    MyOpenHelper(Context context) {
        super(context, "PTJ_DataBase", null, 1);
    }

    //一番最初にDBが作られた時に行われる処理。DBの作成
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ptj(" + " ptj_name text not null," + "salary text not null" + ");");
        db.execSQL("create table shift(" + " date text not null," + "time text not null" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}