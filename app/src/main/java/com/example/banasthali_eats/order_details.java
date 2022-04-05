package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class order_details extends AppCompatActivity {
Button toMainPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        toMainPage=(Button) findViewById(R.id.toMainPageBtn);
        toMainPage.setOnClickListener((v) -> {
            startActivity( new Intent(order_details.this,orderPage.class ));
        });
    }
}