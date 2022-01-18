package com.example.banasthali_eats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseFirestore fStore;

    private TextView signUp, forgotPassword;
    private EditText email, password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        signUp = findViewById(R.id.txtSignUp);
        signUp.setOnClickListener(this);

        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(this);

        forgotPassword = findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.txtSignUp:
                startActivity(new Intent(this, RegisterUser.class));
                break;
            case R.id.btnLogin:
                userLogin();
                break;
            case R.id.forgotPassword:
                startActivity(new Intent(this, ForgotPassword.class));
                break;
        }
    }

    private void userLogin() {
        String mail = email.getText().toString().trim();
        String pwd = password.getText().toString().trim();

        if(mail.isEmpty()) {
            email.setError("Mail is required");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            email.setError("Provide valid email");
            email.requestFocus();
            return;
        }
        if(pwd.length() < 6){
            password.setError("Password min length must be 6");
            password.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(mail, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    if(user.isEmailVerified()){
                        startActivity(new Intent(MainActivity.this, UserActivity.class));
                    }else{
                        Toast.makeText(MainActivity.this, "Please verify your account.", Toast.LENGTH_LONG).show();
                        user.sendEmailVerification();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Failed to logged in please check you credentials", Toast.LENGTH_LONG).show();
                }
            }
        });

//        mAuth.signInWithEmailAndPassword(mail, pwd)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            // user has been logged in
//                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                            if(user.isEmailVerified()){
//                                startActivity(new Intent(MainActivity.this, UserActivity.class));
//                            }else{
//                                user.sendEmailVerification();
//                                Toast.makeText(MainActivity.this, "Check your email to verify account.", Toast.LENGTH_LONG).show();
//                            }
//                        }else{
//                            Toast.makeText(MainActivity.this, "Failed to logged in please check you credentials", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
    }
}