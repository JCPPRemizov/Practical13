package com.example.practical13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dateTxt, timeTxt;
    Button datePick, timePick;
    Button applyBtn;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTxt = findViewById(R.id.date_txt);
        timeTxt = findViewById(R.id.time_txt);

        datePick = findViewById(R.id.date_picker);
        timePick = findViewById(R.id.time_picker);

        applyBtn = findViewById(R.id.apply_button);

        datePick.setOnClickListener(view -> {
            int selectedYear = 2000;
            int selectedMonth = 2;
            int selectedDay = 2;

            DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    dateTxt.setText("" + i + "-" + (i1 + 1) + "-" + i2);
                }
            };
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, dateSetListener, selectedYear, selectedMonth, selectedDay);
            datePickerDialog.show();
        });

        timePick.setOnClickListener(view -> {
            boolean is24HView = true;
            int selectedHour = 10;
            int selectedMinute = 20;

            TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    timeTxt.setText(hourOfDay + ":" + minute);
                }
            };
            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, timeSetListener, selectedHour, selectedMinute, is24HView);
            timePickerDialog.show();
        });

        applyBtn.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Подтверждение записи")
                    .setMessage("Вы подтверждаете вашу запись?")
                    .setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            Toast.makeText(MainActivity.this, "Ваша запись подтверждена", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create();
            builder.show();
        });
    }
}