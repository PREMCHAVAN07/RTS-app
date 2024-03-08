// RegistrationActivity.java
package com.example.rtsragistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {


    private Button buttonSignIn;
    private Button buttonCreateUser;
    private Button buttonVerifyProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ragistration);



        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonCreateUser = findViewById(R.id.buttonCreateUser);
        buttonVerifyProduct = findViewById(R.id.buttonVerifyProduct);



        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), mobilenumber.class);
                startActivity(intent);
            }
        });

        buttonCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), new_user.class);
                startActivity(intent);
            }
        });

        buttonVerifyProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), verificationProduct.class);
                startActivity(intent);
            }
        });
    }

}
