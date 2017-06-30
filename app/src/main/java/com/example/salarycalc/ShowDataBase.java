package com.example.salarycalc;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShowDataBase extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ptj);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        MyOpenHelper helper = new MyOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();


        // queryメソッドの実行例
        Cursor c = db.query("ptj", new String[] { "ptj_name", "salary" }, null,
                null, null, null, null);

        boolean mov = c.moveToFirst();
        while (mov) {
            TextView textView = new TextView(this);
            textView.setText(String.format("%s : %d円", c.getString(0), c.getInt(1)));
            mov = c.moveToNext();
            layout.addView(textView);
        }
        c.close();
        db.close();
/*
        MyOpenHelperShift helperS = new MyOpenHelperShift(this);
        final SQLiteDatabase dbS = helperS.getWritableDatabase();

        //TextView show = (TextView) findViewById(R.id.show_shift);

        Cursor cS = dbS.query("shift", new String[]{"shift_name", "date", "time"}, null, null, null, null, null);

        boolean movS = cS.moveToFirst();
        String shifts = "";

        while (movS) {
            TextView textView = new TextView(this);
            textView.setText(String.format("バイト：%s 　日付 : %s 　時間 : %d 時間",c.getString(0), c.getString(1), c.getInt(2)));
            movS = cS.moveToNext();
            layout.addView(textView);
        }
        cS.close();
        dbS.close();
        */

    }
}