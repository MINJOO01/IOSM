package com.cookandroid.toodeole_iosm;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class Loading extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;             // 파이어베이스 인증

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        mFirebaseAuth = FirebaseAuth.getInstance();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView splashGif = (ImageView)findViewById(R.id.imageView);
        Glide.with(this).load(R.drawable.loading).into(splashGif);
        Handler timer=new Handler();
        //이미 로그인한적이 있는지 확인합니다.
        if (mFirebaseAuth == null) {
            timer.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(getApplication(), LoginActivity.class);
                    startActivity(intent);
                    finish();

                }
            },3400);
        }else{
            timer.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(getApplication(), SecondActivity.class);
                    startActivity(intent);
                    finish();

                }

            },3400);

        }
    }

}

