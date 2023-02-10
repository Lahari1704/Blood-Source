package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity7 extends AppCompatActivity {


    private Button textview3,textview4,textview6,textview7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);


        textview3=findViewById(R.id.textView3);
        textview4=findViewById(R.id.textView4);
        textview6=findViewById(R.id.textView6);
        textview7=findViewById(R.id.textView7);

        textview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity7.this,MainActivity8.class);
                startActivity(intent);
            }
        });
        textview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity7.this,MainActivity8.class);
                startActivity(intent);
            }
        });
        textview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity7.this,MainActivity8.class);
                startActivity(intent);
            }
        });
        textview7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity7.this,MainActivity8.class);
                startActivity(intent);
            }
        });
    }
}