package com.udinus.nepchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SuccessActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success2);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(SuccessActivity2.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}