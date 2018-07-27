package com.example.android.netsurf;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class Splash extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    FrameLayout frameLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        button = (Button) findViewById(R.id.startingbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
            }
        });

        frameLayout = (FrameLayout)findViewById(R.id.myFrameLayout);
        animationDrawable = (AnimationDrawable)frameLayout.getBackground();

        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);

        animationDrawable.start();

        }

}
