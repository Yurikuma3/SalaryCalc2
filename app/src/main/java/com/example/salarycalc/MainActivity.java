package com.example.salarycalc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.salarycalc.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyOpenHelperShift helper1 = new MyOpenHelperShift(this);
        final SQLiteDatabase db = helper1.getWritableDatabase();

        TextView show = (TextView) findViewById(R.id.show_shift);

        Cursor c = db.query("shift", new String[]{"shift_name", "date", "time"}, null, null, null, null, null);

        boolean mov = c.moveToFirst();
        String shifts = "";

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> times = new ArrayList<Integer>();
        while (mov) {
            shifts += String.format("%s 　日付 : %s 　時間 : %d 時間 \n",c.getString(0), c.getString(1), c.getInt(2));
            names.add(c.getString(0));
            times.add(c.getInt(2));
            mov = c.moveToNext();
        }

        show.setText(shifts);

        // 合計金額を表示
        MyOpenHelper helper2 = new MyOpenHelper(this);
        final SQLiteDatabase db2 = helper2.getWritableDatabase();

        TextView showSum = (TextView) findViewById(R.id.lblSum);
        Cursor cp = db2.query("ptj", new String[]{"ptj_name", "salary"}, null, null, null, null, null);

        boolean mov2 = cp.moveToFirst();
        String s;
        int sum=0;
        while(mov2) {
            s = cp.getString(0);

            for(int i=0; i<names.size(); i++) {
                if(s.equals(names.get(i))) {
                    sum += times.get(i) * cp.getInt(1);
                }
            }
            mov2 = cp.moveToNext();
        }

       showSum.setText("給料合計： "+sum+"円");

        c.close();
        cp.close();
        db.close();
        db2.close();
    }

    public void toAddPTJ(View view) {
        Intent intent = new Intent(this, AddPTJActivity.class);
        startActivity(intent);
    }

    public void toAddShift(View view) {
        Intent intent = new Intent(this, AddShiftActivity.class);
        startActivity(intent);
    }
/*
    public void updateShift(){
        //setContentView(R.layout.activity_main);

        MyOpenHelperShift helper = new MyOpenHelperShift(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        TextView show = (TextView) findViewById(R.id.show_shift);

        Cursor c = db.query("shift", new String[]{"shift_name", "date", "time"}, null, null, null, null, null);

        boolean mov = c.moveToFirst();
        String shifts = "";

        while (mov) {
            shifts += String.format("バイト：%s 　日付 : %s 　時間 : %d 時間 \n",c.getString(0), c.getString(1), c.getInt(2));
            mov = c.moveToNext();
        }
        c.close();
        db.close();

        show.setText(shifts);
    }
*/
    public void dbClear(View v){
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("ptj", null, null);

        MyOpenHelperShift helpers = new MyOpenHelperShift(this);
        final SQLiteDatabase db2 = helpers.getWritableDatabase();
        db2.delete("shift",null, null);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Disable Back key
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
