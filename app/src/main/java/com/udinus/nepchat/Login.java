package com.udinus.nepchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;
    EditText editTextEmail;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);

        editTextEmail = findViewById(R.id.edt_txt_email);
        editTextPassword = findViewById(R.id.edt_txt_password);
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

    public void clickLogin (View view){
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Email and Password can't be empty!",Toast.LENGTH_LONG).show();
        }
        else
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email can't be empty!",Toast.LENGTH_LONG).show();
        }
        else
        if (!isValidEmail(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Invalid Email!",Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(editTextPassword.getText().toString())){
            Toast.makeText(view.getContext(),"Password can't be empty!",Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(Login.this,SuccessActivity.class);
            startActivity(i);
        }
    }

    public void clickForgot (View view){
        Intent i = new Intent(Login.this,ForgotPassword.class);
        startActivity(i);
    }

    public void clickRegister (View view){
        Intent i = new Intent(Login.this,Register.class);
        startActivity(i);
    }

    public static boolean isValidEmail (CharSequence email){
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}