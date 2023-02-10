package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity6 extends AppCompatActivity {

private EditText Name,Dob,phone_number,address,Bloodgroup,dondate;
private Button donatebtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Name = findViewById(R.id.Name);
        Dob = findViewById(R.id.Dob);
        phone_number = findViewById(R.id.phone_number);
        address = findViewById(R.id.address);
        Bloodgroup = findViewById(R.id.Bloodgroup);
        dondate = findViewById(R.id.dondate);
        donatebtn = findViewById(R.id.donatebtn);
        donatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> v = new HashMap<>();
                v.put("Name", Name.getText().toString());
                v.put("Dob", Dob.getText().toString());
                v.put("Phone number", phone_number.getText().toString());
                v.put("Address", address.getText().toString());
                v.put("Blood Group", Bloodgroup.getText().toString());
                v.put("Last donation date", dondate.getText().toString());
                //FirebaseFirestore.getInstance().collection("User").document("Details").set(v).addOnCompleteListener(new OnCompleteListener<Void>() {
                FirebaseFirestore.getInstance().collection("User").add(v).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {

                        Toast.makeText(getApplicationContext(), "INSERTED", Toast.LENGTH_SHORT).show();



                    }


                    //@Override
                    //public void onComplete(@NonNull Task<Void> task) {
                    //Toast.makeText(getApplicationContext(), "Data saved", Toast.LENGTH_SHORT).show();


                });

                //to next page
                Intent intent = new Intent(MainActivity6.this,MainActivity7.class);
                startActivity(intent);
                finish();
            }
        });
    }



}