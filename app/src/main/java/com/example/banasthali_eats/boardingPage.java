package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class boardingPage extends AppCompatActivity {
Button toMainPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarding_page);
        toMainPage=(Button) findViewById(R.id.getStartedBtn);
        toMainPage.setOnClickListener((v) -> {
            startActivity( new Intent(boardingPage.this,orderPage.class ));
        });
    }
}