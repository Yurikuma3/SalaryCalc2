package com.example.salarycalc;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.Spinner;

import static com.example.salarycalc.R.id.textView;

public class AddShiftActivity extends AppCompatActivity {

    NumberPicker numPicker;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shift);

        spinner = (Spinner)findViewById(R.id.spinner);

        numPicker = (NumberPicker)findViewById(R.id.numPicker);
        numPicker.setMaxValue(9);
        numPicker.setMinValue(1);

    }

    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        //textView.setText( String.valueOf(year)  + "/ " + String.valueOf(monthOfYear + 1) + "/ " + String.valueOf(dayOfMonth) );

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePick();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


}
