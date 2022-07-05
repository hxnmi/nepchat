package com.udinus.nepchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ResetPassword extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;
    EditText editTextConfirmPassword;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        getSupportActionBar().hide();

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);

        editTextPassword = findViewById(R.id.edt_new_password);
        editTextConfirmPassword = findViewById(R.id.edt_confirm_password);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (animationDrawable != null && animationDrawable.isRunning()){
            animationDrawable.stop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (animationDrawable != null && !animationDrawable.isRunning()){
            animationDrawable.start();
        }
    }

    public void clickChangePassword (View view){
        if (TextUtils.isEmpty(editTextPassword.getText().toString())){
            Toast.makeText(view.getContext(),"Enter your new password!",Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(editTextConfirmPassword.getText().toString())){
            Toast.makeText(view.getContext(),"Password must be confirmed!",Toast.LENGTH_LONG).show();
        }
        else if (!editTextPassword.getText().toString().trim().equals(editTextConfirmPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Your password and confirmation password do not match.",Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(ResetPassword.this,SuccessActivity2.class);
            startActivity(i);
        }
    }
}