package com.example.salarycalc;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AddPTJActivity extends AppCompatActivity {

    //NumberPicker numberPicker;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ptj);
    }

    public void showData(View v) {
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        final EditText txt_jobname = (EditText) findViewById(R.id.txt_jobname); // テキストの場所を見つけて
        final EditText txt_salary = (EditText) findViewById(R.id.txt_salary);
        String jobname = txt_jobname.getText().toString(); // Stringに直す
        String salary = txt_salary.getText().toString();

        ContentValues contentValues = new ContentValues();
        contentValues.put("ptj_name", jobname);
        contentValues.put("salary", salary);
        //long id = db.insert("ptj", jobname, contentValues); // 登録したデータのIDを取得

        //データを表示する
        setContentView(R.layout.show_database);
        Intent dbIntent = new Intent(AddPTJActivity.this,ShowDataBase.class);
        startActivity(dbIntent);
    }
    /*
    private void findViews() {
        Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView = new TextView(this);
        /*
        textView.setTextSize(40);
        textView.setText(message);
        */
/*
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_add_ptj);
        layout.addView(textView);
    }
    */

}
