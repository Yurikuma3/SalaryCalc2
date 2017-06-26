package com.example.salarycalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

public class AddPTJActivity extends AppCompatActivity {

    //NumberPicker numberPicker;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ptj);

        //findViews();
    }

    private void findViews() {
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        //numberPicker = (NumberPicker)findViewById(R.id.numPicker1);
        //int val = numberPicker.getValue();

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_add_ptj);
        layout.addView(textView);
    }

}
