package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseCanteen extends AppCompatActivity {
    private Button kcanteen, law, pharma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_canteen);

        kcanteen = findViewById(R.id.button0);
        law = findViewById(R.id.button1);
        pharma = findViewById(R.id.button2);
        kcanteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseCanteen.this, KCanteen.class);
                startActivity(i);
            }
        });

        law.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseCanteen.this, lawCanteen.class);
                startActivity(i);
            }
        });

        pharma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseCanteen.this, pharmacyCanteen.class);
                startActivity(i);
            }
        });
    }
}