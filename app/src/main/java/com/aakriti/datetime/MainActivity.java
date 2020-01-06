package com.aakriti.datetime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView txtFrom, txtTo, txtTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFrom= findViewById(R.id.txtFrom);
        txtTo= findViewById(R.id.txtTo);
        txtTime= findViewById(R.id.txtTime);

        txtFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();

            }
        });

        txtTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePickers();
            }
        });

        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });

    }

    private void loadTime(){
        final Calendar c= Calendar.getInstance();
        final int hour = c.get(Calendar.YEAR);
        int minute = c.get(Calendar.MINUTE);
        int second = c. get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String amPm;
                if (hourOfDay>=12){
                    hourOfDay=12;
                    amPm= "PM";
                }
                else
                {
                    amPm= "AM";
                }
                txtTime.setText("Time is: " + hourOfDay + ":" + minute + amPm);
            }
        }, hour, minute, false);
                timePickerDialog.show();
    }


    private void loadDatePicker(){
        //use the current date
        final Calendar c= Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c. get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, this, year,month,day

        );
        datePickerDialog.show();


    }
    private void loadDatePickers(){
        //use the current date
        final Calendar c= Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c. get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, this, year,month,day

        );
        datePickerDialog.show();


    }
//After selecting a date from date picker

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date= "Month/Day/Year:" + month + "/" + dayOfMonth + "/" + year;
        txtFrom.setText(date);

    }


}
