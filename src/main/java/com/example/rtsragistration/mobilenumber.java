package com.example.rtsragistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class mobilenumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobilenumber);

        //init
        final EditText inputMobile = findViewById(R.id.inputMobile);
        final Button buttonGetOtp = findViewById(R.id.buttonGetOTP);

        final ProgressBar progressBar = findViewById(R.id.progressBar);

        buttonGetOtp.setOnClickListener(v -> {

            if(inputMobile.getText().toString().isEmpty()){
                Toast.makeText(mobilenumber.this, "Enter mobile", Toast.LENGTH_SHORT).show();
                return;
            }
            //set visibility
            buttonGetOtp.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);

            Intent intent = new Intent(getApplicationContext(), optverification.class);
            intent.putExtra("mobile", inputMobile.getText().toString());
            startActivity(intent);
        });
    }
}
