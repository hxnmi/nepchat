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

public class Register extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;
    EditText editTextName;
    EditText editTextEmail;
    EditText editTextConfirmPassword;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);

        editTextName = findViewById(R.id.edt_name);
        editTextEmail = findViewById(R.id.edt_txt_email);
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

    public void sign_up (View view){
        if(TextUtils.isEmpty(editTextName.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Name can't be empty!",Toast.LENGTH_LONG).show();
        }
        else
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
            Toast.makeText(view.getContext(),"Enter your new password!",Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(editTextConfirmPassword.getText().toString())){
            Toast.makeText(view.getContext(),"Password must be confirmed!",Toast.LENGTH_LONG).show();
        }
        else if (!editTextPassword.getText().toString().trim().equals(editTextConfirmPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Your password and confirmation password do not match.",Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(Register.this,SuccessActivity3.class);

            String textname = editTextName.getText().toString();
            i.putExtra("edt_name",textname);

            startActivity(i);
        }
    }

    public static boolean isValidEmail (CharSequence email){
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}