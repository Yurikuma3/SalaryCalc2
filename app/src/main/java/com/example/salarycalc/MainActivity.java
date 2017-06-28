package com.example.salarycalc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.salarycalc.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String s = "ここだよ";
        TextView textView = (TextView)findViewById(R.id.showShift);
        textView.setText(s);

        MyOpenHelper helper = new MyOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query("ptj",new String[] {"ptj_name"}, null,null,null,null,null);

        boolean mov = c.moveToFirst();
        while (mov) {
            s += String.format("%s\n", c.getString(0));
            mov = c.moveToNext();
        }
        c.close();
        db.close();
        textView.setText(s);
    }

    public void addPTJ(View view) {
        Intent intent = new Intent(this, AddPTJActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void addShift(View view) {
        Intent intent = new Intent(this, AddShiftActivity.class);
        startActivity(intent);
    }
}
