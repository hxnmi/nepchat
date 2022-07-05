package com.udinus.nepchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetCode extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;
    EditText editTextCode;
    TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_code);
        getSupportActionBar().hide();

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);

        editTextCode = findViewById(R.id.edt_reset_code);
        textViewEmail = findViewById(R.id.txt_email);

        Intent result = getIntent();
        String textemail  = result.getStringExtra("edt_txt_email");
        textViewEmail.setText(textemail);

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

    public void clickContinue (View view){
        if(TextUtils.isEmpty(editTextCode.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Reset Code can't be empty!", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(ResetCode.this,ResetPassword.class);
            startActivity(i);
        }
    }
}
