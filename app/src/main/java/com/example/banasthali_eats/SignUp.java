package com.example.banasthali_eats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {
    EditText email,name,password,pno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email=findViewById(R.id.email);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        pno=findViewById(R.id.pno);
    }
    public  void signup(View v)
    {
        String e=email.getText().toString();
        if(e.length()==0)
        {
            email.setError("Enter email");
            return;
        }
        String p=password.getText().toString();
        if(p.length()<8)
        {
            password.setError("Enter Longer password");
            return;
        }
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(e,p).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                String n=name.getText().toString();
                String pn=pno.getText().toString();
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                DocumentReference d = db.collection("Users Info").document(e);
                HashMap<String,Object> user=new HashMap<>();
                user.put("Name",n);
                user.put("Email",e);
                user.put("Phone Number",pn);
                d.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(SignUp.this,"Signup successfull",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUp.this,Login.class));
                        finish();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUp.this,e.toString(),Toast.LENGTH_SHORT).show();

            }
        });

    }

}