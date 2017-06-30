package com.example.salarycalc;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyOpenHelperShift extends SQLiteOpenHelper {

    MyOpenHelperShift(Context context) {
        super(context, "Shift_DataBase", null, 1);
    }

    //一番最初にDBが作られた時に行われる処理。DBの作成
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table shift(" + "shift_name text not null," + "date text not null," + "time integer not null" + ");");
        //System.out.println("データベース作れたよ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}