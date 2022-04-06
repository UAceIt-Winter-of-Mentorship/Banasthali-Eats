package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class payment_page extends AppCompatActivity {
Button toOrderPlaced;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        toOrderPlaced=(Button) findViewById(R.id.placeOrderBtn);
        toOrderPlaced.setOnClickListener((v) -> {
            startActivity( new Intent(payment_page.this,order_placed.class ));
        });
    }
}