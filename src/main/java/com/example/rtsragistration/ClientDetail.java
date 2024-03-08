package com.example.rtsragistration;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Connection;
import java.util.Calendar;

import getconnection.Getcon;

public class ClientDetail extends AppCompatActivity {
    private Button nxt;
    private EditText editTextDate;
    private Spinner district;
    private Spinner tahasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);


        nxt = findViewById(R.id.next);
        editTextDate = findViewById(R.id.editTextDate);
        district = findViewById(R.id.district);
        tahasil = findViewById(R.id.tahasil);
        final String text;
        Connection con = null;
        TextView textView = findViewById(R.id.textView4);
        System.out.println("hello");

            Connection connection = Getcon.getconnection();
            text = connection+"";
        System.out.println(text+" hey");
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ClientDetailpage2.class);
                startActivity(intent);
            }
        });

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

        private void showDatePickerDialog() {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                            editTextDate.setText(selectedDate);
                        }
                    }, year, month, dayOfMonth);

            datePickerDialog.show();
        }

        //database connection


    }


