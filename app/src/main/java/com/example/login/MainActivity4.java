package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;


public class MainActivity4 extends AppCompatActivity
{
     TextView  textdata;
     FirebaseFirestore db;
     @Override
     protected void onCreate(Bundle savedInstanceState){
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main4);

         textdata=findViewById(R.id.textdata);
         db=FirebaseFirestore.getInstance();

         textdata.setText("");
         fetchdata();
     }

     public void fetchdata(){


         db.collection("User")
                 //.whereEqualTo("Blood Group","A+")
                 .get()
                 .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                             String data=document.getString("Blood Group");
                            // if(data.contains("A+"))
                                 textdata.append("NAME: " + document.getString("Name") + "\n BLOOD GROUP: " + document.getString("Blood Group")+"\nADDRESS: " + document.getString("Address")+"\nPHONE NUMBER:"+document.getString("Phone number")+"\n\n");

                         }
                     }
                 });
     }
    }