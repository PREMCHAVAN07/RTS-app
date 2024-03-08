package com.example.rtsragistration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ClientDetailpage2 extends AppCompatActivity {
    private Button btnprevious;
    private ImageView photo,ownerid, productphoto;
    private ImageView getImageview;
    private final int imgcode = 100;
    private Button btnpay;
    private CheckBox checkbox;
    TextView selfdeclaration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detailpage2);

        photo = findViewById(R.id.photo);
        ownerid = findViewById(R.id.OwnerId);
        productphoto = findViewById(R.id.productphoto);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageview = photo;
                Intent getimg = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(getimg, imgcode);

            }
        });

        ownerid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageview = ownerid;
                Intent getimg = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(getimg, imgcode);

            }
        });

        productphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageview = productphoto;
                Intent getimg = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(getimg, imgcode);

            }
        });


        btnprevious = findViewById(R.id.previous);
        btnpay = findViewById(R.id.pay);
        checkbox = findViewById(R.id.selfdeclaration);
        btnpay.setEnabled(false);
        selfdeclaration = findViewById(R.id.textView56);
        String text = "I, hereby solemnly affirm and state that the business which I, have started is not banned or prohibited by any Act, Rules, Law or Order of any Court of Law or any competent authority and the premises where I/We are conducting the said business is free from violation of any Act, Rules, Order of any Court of Law or any Competent Authority.\n" +
                "\n I, hereby declare that the information provided above is true and correct to the best of my/our personal knowledge, information and belief. I/We am/are fully aware about the consequences of giving false information. If the information is found to be false, I/We shall be liable for prosecution and punishment law applicable thereto.\n" +
                "\n I, have obtained necessary licenses, permissions, permit for the conduct of this business and the place of business from the appropriate Authority.\n" +
                "\nI, shall be responsible and liable for legal action if the business is conducted without proper licence, permission, permit from the appropriate Authority. running of such business is prohibited by any law or order of any Competent Authority.";
        selfdeclaration.setText(text);


        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    btnpay.setEnabled(true);
                }

                if(!isChecked){
                    btnpay.setEnabled(false);
                }
            }
        });


        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), success.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==imgcode){
                Bitmap img = (Bitmap) data.getExtras().get("data");
                getImageview.setImageBitmap(img);
            }
        }
    }
}