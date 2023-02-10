package com.example.login;

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
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3 extends AppCompatActivity {

    private Button resetpasswordbutton;
    private EditText ediText_password_reset_email;
    private String email;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        auth=FirebaseAuth.getInstance();

        ediText_password_reset_email=findViewById(R.id.ediText_password_reset_email);
        resetpasswordbutton=findViewById(R.id.resetpasswordbtn);

        resetpasswordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });


    }

    private void validateData() {

        email=ediText_password_reset_email.getText().toString();

        if(email.isEmpty())
        {
            ediText_password_reset_email.setError("Required");
        }else{
            forgetpass();
        }
    }

    private void forgetpass() {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity3.this, "Check your Email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity3.this,MainActivity.class));
                            finish();
                        }else{
                            Toast.makeText(MainActivity3.this, "Error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    } 

}