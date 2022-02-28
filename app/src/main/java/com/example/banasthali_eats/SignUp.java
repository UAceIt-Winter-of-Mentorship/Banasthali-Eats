package com.example.banasthali_eats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    TextInputLayout clgid,userName,mail,phone,password;
    Button blogin,signup;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        clgid = findViewById(R.id.college_Id);
        userName = findViewById(R.id.UserName);
        mail = (TextInputLayout)findViewById(R.id.email);
        phone = findViewById(R.id.phone_number);
        password = (TextInputLayout)findViewById(R.id.Pass);
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        blogin = findViewById(R.id.Blogin);
        signup = findViewById(R.id.Signup);
        fStore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null){
            //startActivity(new Intent());
            finish();
        }
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mail.getEditText().getText().toString().trim();
                String Password = password.getEditText().getText().toString().trim();
                String cId = clgid.getEditText().getText().toString();
                String Name = userName.getEditText().getText().toString();
                String Phone = phone.getEditText().getText().toString();


                if(TextUtils.isEmpty(email)){
                    mail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                    password.setError("Password is required");
                    return;
                }
                if(Password.length() < 6){
                    password.setError("Password must be greater then 6 digit");
                }
                progressBar.setVisibility(view.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUp.this,"User created",Toast.LENGTH_SHORT).show();
                            userId = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userId);
                            Map<String,Object> user = new HashMap<>();
                            user.put("collegeid",cId);
                            user.put("name",Name);
                            user.put("mailId",email);
                            user.put("phone",Phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d("TAG","onSuccess user profile created for "+userId);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("TAG","onFailure "+e.toString());
                                }
                            });
                           // startActivity(new Intent());
                            progressBar.setVisibility(view.GONE);
                        }else{
                            Toast.makeText(SignUp.this,"error! "+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(view.GONE);
                        }
                    }
                });
            }
        });
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this,Login.class));

            }
        });
    }
}