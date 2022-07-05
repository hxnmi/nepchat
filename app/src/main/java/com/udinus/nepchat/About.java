package com.udinus.nepchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

public class About extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().hide();

        ConstraintLayout constraintLayout;
        AnimationDrawable animationDrawable;

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);

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
}
