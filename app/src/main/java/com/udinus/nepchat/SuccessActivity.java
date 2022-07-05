package com.udinus.nepchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(SuccessActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },1000);
    }
}