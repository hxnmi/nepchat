package com.udinus.nepchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SuccessActivity3 extends AppCompatActivity {

    TextView textViewname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success3);
        getSupportActionBar().hide();

        textViewname = findViewById(R.id.txt_name);
        Intent result = getIntent();
        String textname  = "Hi!  " + result.getStringExtra("edt_name") + " ,";
        textViewname.setText(textname);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(SuccessActivity3.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}