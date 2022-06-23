package com.cookandroid.toodeole_iosm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class menu2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2);


        Button menu1 = (Button)findViewById(R.id.menu1);
        menu1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.cookandroid.toodeole_iosm.menu1.class);
                startActivity(intent);
            }} );


        Button menu2 = (Button) findViewById(R.id.menu2);
        menu2.setOnClickListener(new View.OnClickListener(){
                                     public void onClick (View v) {
                                         Intent intent2 = new Intent(getApplicationContext(), menu2.class);
                                         startActivity(intent2);
                                     }
                                 }
        );
        Button menu3 = (Button) findViewById(R.id.menu3);
        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), com.cookandroid.toodeole_iosm.menu3.class);
                startActivity(intent3);

            }
        });

    }
    }


