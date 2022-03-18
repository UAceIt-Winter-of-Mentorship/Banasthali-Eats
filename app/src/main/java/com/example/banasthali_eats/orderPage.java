package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class orderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        String snacks []={"burger", "ice cream"};
        LinearLayout ll= findViewById(R.id.ll);
        for(int i = 0;i< snacks.length;i++){
            View v= getLayoutInflater().inflate(R.layout.snacks_repeat, null);
            TextView name= v.findViewById(R.id.foodName);
            name.setText(snacks[i]);
            ll.addView(v);
        }

    }
}