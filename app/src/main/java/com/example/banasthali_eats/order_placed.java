package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class order_placed extends AppCompatActivity {
Button toMainPage;
Button toOrderDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);
        toMainPage=(Button) findViewById(R.id.toMainPageBtn);
        toMainPage.setOnClickListener((v) -> {
            startActivity( new Intent(order_placed.this,orderPage.class ));
        });
        toOrderDetails=(Button) findViewById(R.id.toOrderDetails);
        toMainPage.setOnClickListener((v) -> {
            startActivity( new Intent(order_placed.this,order_details.class ));
        });
    }
}