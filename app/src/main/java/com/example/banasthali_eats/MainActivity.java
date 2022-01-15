package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //testBranch
        setContentView(R.layout.activity_main);
        TextView tap=findViewById(R.id.textView2);
        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Login.class);
                startActivity(i);
                finish();
            }
        });
        //login screen
        //signup screen
    }
    //method 2
/*    public void func(View v)
    {
        Intent i=new Intent(MainActivity.this,Login.class);
        startActivity(i);
        finish();
    }*/
}