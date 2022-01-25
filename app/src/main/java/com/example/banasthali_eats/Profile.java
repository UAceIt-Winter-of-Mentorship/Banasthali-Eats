package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        back = findViewById(R.id.back);
    }
    public void fun(View view)
    {
        startActivity(new Intent(Profile.this, Login.class));
    }
}