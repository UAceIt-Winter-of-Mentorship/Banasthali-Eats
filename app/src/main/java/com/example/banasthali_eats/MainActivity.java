package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.service.autofill.TextValueSanitizer;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.window.SplashScreen;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000;
    Animation topanim;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //test
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //supportActionBar?.hide();


        topanim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        textView = findViewById(R.id.textView);
        textView.setAnimation(topanim);
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent intent = new Intent(MainActivity.this, Login.class);
              startActivity(intent);
              finish();
          }
      },SPLASH_SCREEN);

    }
}