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
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private Button btnsignUp;
    private EditText name, email, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        btnsignUp = findViewById(R.id.btnSignUp);
        btnsignUp.setOnClickListener(this);

        name = findViewById(R.id.signUpName);
        email = findViewById(R.id.signUpEmail);
        password = findViewById(R.id.signUpPassword);
        confirmPassword = findViewById(R.id.signUpConfirmPassword);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.txtLogIn:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btnSignUp:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String nm = name.getText().toString().trim();
        String mail = email.getText().toString().trim();
        String pwd = password.getText().toString().trim();
        String cpwd = confirmPassword.getText().toString().trim();

        if(nm.isEmpty()){
            name.setError("Full name is required");
            name.requestFocus();
            return;
        }
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
        if(!Objects.equals(pwd, cpwd)){
            password.setError("Password and confirm password must be same");
            password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(mail, pwd)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(nm, mail);
                            // realtime db on
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(RegisterUser.this, "Registered successfully", Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(RegisterUser.this, "Failed to Register in DB", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }else{
                            // can occur
                            // if rules is not true
                            // if signin method is not initilized
                            // or many more..
                            Toast.makeText(RegisterUser.this, "Failed to Register", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}