package com.example.rtsragistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomescreenActivity extends AppCompatActivity {

    private Button verificationButton;
    private Button registrationButton;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);


        registrationButton = findViewById(R.id.button3);
        verificationButton = findViewById(R.id.button4);
        webView = findViewById(R.id.webView);

//         Set click listeners for buttons
        verificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), verificationProduct.class);
                startActivity(intent);
            }
        });

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ClientDetail.class);
                startActivity(intent);

            }
        });

        setupWebView();
    }

    private void setupWebView() {
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        webView.setWebViewClient(new WebViewClient()); // Open links in the same WebView, not in a browser
    }

    private void loadWebViewUrl(String url) {
        webView.loadUrl("https://www.flipkart.com/");
    }
}
