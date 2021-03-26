package com.example.date_picker_and_time_picker;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity     implements View.OnClickListener {

    private EditText eDate, eTime;
    private Button btDate, btTime;
    private int mDay, mMonth, mYear, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_picker_and_time_picker);
        initView();
        btDate.setOnClickListener(this);
        btTime.setOnClickListener(this);

    }

    private void initView() {
        eDate = findViewById(R.id.txtDate);
        eTime = findViewById(R.id.txtTime);
        btDate = findViewById(R.id.btDate);
        btTime = findViewById(R.id.btTime);
    }
    @Override
    public void onClick(View v) {
        if (v == btDate) {
            //get Current Date
            Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int y, int m, int day) {
                    eDate.setText(day + "/" + (m + 1) + "/" + y);
                }
            }, mYear, mMonth, mDay);
            dialog.show();
        }
        if (v == btTime) {
            Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR);
            mMinute = c.get(Calendar.MINUTE);
            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hour, int minute) {
                    eTime.setText(hour + ":" + minute);
                }
            }, mHour, mMinute, false);
            dialog.show();
        }
    }

}