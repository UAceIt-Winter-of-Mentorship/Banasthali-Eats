package com.example.banasthali_eats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email2);
        pass=findViewById(R.id.pass);
    }
    public void tosignup(View V)
    {
        startActivity(new Intent(Login.this,SignUp.class));
    }
    public void login(View V)
    {
        //checks
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        String e=email.getText().toString();
        String p=pass.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(e,p).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                startActivity(new Intent(Login.this,FirstAct.class));
            }
        });
    }
}