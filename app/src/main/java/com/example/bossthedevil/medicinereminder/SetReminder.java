package com.example.bossthedevil.medicinereminder;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.TimeZone;

public class SetReminder extends AppCompatActivity {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int seconds;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder);
// Get current calendar date and time.
        Calendar currCalendar = Calendar.getInstance();

        // Set the timezone which you want to display time.
        currCalendar.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));

        year = currCalendar.get(Calendar.YEAR);
        month = currCalendar.get(Calendar.MONTH);
        day = currCalendar.get(Calendar.DAY_OF_MONTH);
        hour = currCalendar.get(Calendar.HOUR_OF_DAY);
        minute = currCalendar.get(Calendar.MINUTE);
        seconds = currCalendar.get(Calendar.SECOND);

        showUserSelectDateTime();

        // Get date picker object.
        //DatePicker datePicker = (DatePicker)findViewById(R.id.datePickerExample);
    /*    datePicker.init(year - 1, month  + 1, day + 5, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                SetReminder.this.year = year;
                SetReminder.this.month = month;
                SetReminder.this.day = day;

                showUserSelectDateTime();
            }
        });*/

        // Get time picker object.
        TimePicker timePicker = (TimePicker)findViewById(R.id.timePickerExample);
        timePicker.setHour(this.hour);
        timePicker.setMinute(this.minute);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                SetReminder.this.hour = hour;
                SetReminder.this.minute = minute;
// get the alaram value



                showUserSelectDateTime();
            }
        });

    }

    /* Show user selected date time in bottom text vew area. */
    private void showUserSelectDateTime()
    {
        // Get TextView object which is used to show user pick date and time.
        TextView textView = (TextView)findViewById(R.id.textViewShowDateTime);

        StringBuffer strBuffer = new StringBuffer();
      /*  strBuffer.append("You selected date time : ");
        strBuffer.append(this.year);
        strBuffer.append("-");
        strBuffer.append(this.month+1);
        strBuffer.append("-");
        strBuffer.append(this.day);
        strBuffer.append(" ");*/
        strBuffer.append(this.hour);
        strBuffer.append(":");
        strBuffer.append(this.minute);
        strBuffer.append(":");
        strBuffer.append(this.seconds);

        textView.setText(strBuffer.toString());
        textView.setTextColor(Color.BLUE);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
    }
}