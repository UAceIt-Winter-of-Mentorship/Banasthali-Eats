package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //test
        setContentView(R.layout.activity_main);
        TextView t=new TextView(this);
    }
}