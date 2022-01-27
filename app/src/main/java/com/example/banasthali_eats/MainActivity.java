package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    Button log,reg;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = findViewById(R.id.log);
        reg = findViewById(R.id.reg);

    }

    public void login(View view){
        Intent log = new Intent(MainActivity.this,Login.class);
        startActivity(log);
    }
    public void signup(View view){
        Intent reg = new Intent(MainActivity.this,SignUp.class);
        startActivity(reg);
    }
}