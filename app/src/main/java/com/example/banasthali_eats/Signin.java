package com.example.banasthali_eats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Signin extends AppCompatActivity {
    EditText fullname,email,phone,password,confirm;
    private Button sign;
    private TextView login;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        auth = FirebaseAuth.getInstance();
        fullname = findViewById(R.id.editTextTextPersonName2);
        email = findViewById(R.id.editTextTextPersonName);
        phone = findViewById(R.id.editTextTextPersonName3);
        password= findViewById(R.id.editTextTextPassword);
        confirm = findViewById(R.id.editTextTextPassword2);
        sign = findViewById(R.id.button);
        login = findViewById(R.id.textView2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signin.this,login.class);
                startActivity(i);
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = fullname.getText().toString();
                String e = email.getText().toString();
                String p = phone.getText().toString();
                String pas = password.getText().toString();
                String con = confirm.getText().toString();

                if(n.isEmpty()){
                    fullname.setError("needed");
                    return;
                }
                if(e.isEmpty()){
                    email.setError("needed");
                    return;
                }
                if(p.isEmpty()){
                    phone.setError("needed");
                    return;
                }
                if(pas.isEmpty()){
                    password.setError("needed");
                    return;
                }
                if(con.isEmpty() || !pas.equals(con)){
                    confirm.setError("needed");
                    return;
                }
                createAccount(e,pas);
            }
        });

    }
    private void createAccount(String e,String pas){
        auth.createUserWithEmailAndPassword(e,pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = auth.getCurrentUser();
                    updateUi(user,e);
                }
                else{
                    Toast.makeText(Signin.this,"Signin Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void updateUi(FirebaseUser user,String emm){
        HashMap<String,Object> map = new HashMap<>();
        map.put("Name",fullname.getText().toString());
        map.put("Email",emm);
        map.put("Phone",phone.getText().toString());
        map.put("Password",password.getText().toString());

        DatabaseReference reference = FirebaseDatabase.getInstance("https://banasthali-eats-9ae8b-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("User");
        reference.child(user.getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(Signin.this,MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(Signin.this,"Signin Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}