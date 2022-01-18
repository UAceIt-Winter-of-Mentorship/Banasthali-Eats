package com.example.banasthali_eats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private EditText mail,pass;
    private Button login;
    private TextView signin;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        mail = findViewById(R.id.editTextTextPersonName4);
        pass = findViewById(R.id.editTextTextPassword3);
        login = findViewById(R.id.button2);
        signin = findViewById(R.id.textView4);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this,Signin.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mail.getText().toString();
                String password = pass.getText().toString();

                if(TextUtils.isEmpty(email)){
                    mail.setError("needed");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    pass.setError("needed");
                    return;
                }
                ksk(email,password);
            }
        });
    }
    private void ksk(String email,String password){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(login.this,MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(login.this,"Login Failed" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}