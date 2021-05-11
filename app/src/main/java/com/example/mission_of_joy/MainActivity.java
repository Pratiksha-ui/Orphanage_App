package com.example.mission_of_joy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img1,img2;
    Animation top,bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        img1=(ImageView)findViewById(R.id.Logo);
        img2=(ImageView)findViewById(R.id.SubLogo);

        top= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mainlogoanimation);
        top= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sublogoanimation);

        img1.setAnimation(top);
        img2.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),Login_Activity.class));
            }
        },5000);


    }
}