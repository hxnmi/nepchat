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

public class ForgotPassword extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;
    EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().hide();

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);

        editTextEmail = findViewById(R.id.edt_txt_email);
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

    public void clickNext (View view){
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email can't be empty!",Toast.LENGTH_LONG).show();
        }
        else
        if (!isValidEmail(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Invalid Email",Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(ForgotPassword.this,ResetCode.class);

            String textemail = editTextEmail.getText().toString();
            i.putExtra("edt_txt_email",textemail);

            startActivity(i);
        }
    }

    public static boolean isValidEmail (CharSequence email){
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}