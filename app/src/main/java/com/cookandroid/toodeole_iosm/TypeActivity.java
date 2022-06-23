package com.cookandroid.toodeole_iosm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        ImageButton btn_back = (ImageButton) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FoodActivity.class);
                startActivity(intent);
            }
        });

        Button btn_Chinese = (Button) findViewById(R.id.btn_Chinese);
        btn_Chinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChineseActivity.class);
                startActivity(intent);
            }
        });

        Button btn_Korean = (Button) findViewById(R.id.btn_Korean);
        btn_Korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KoreanActivity.class);
                startActivity(intent);
            }
        });

        Button btn_Japanese = (Button) findViewById(R.id.btn_Japanese);
        btn_Japanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JapaneseActivity.class);
                startActivity(intent);
            }
        });

        Button btn_Western = (Button) findViewById(R.id.btn_Western);
        btn_Western.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WesternActivity.class);
                startActivity(intent);
            }
        });

        Button btn_School = (Button) findViewById(R.id.btn_School);
        btn_School.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SchoolfoodActivity.class);
                startActivity(intent);
            }
        });

        Button btn_Snack = (Button) findViewById(R.id.btn_Snack);
        btn_Snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SnackActivity.class);
                startActivity(intent);
            }
        });




    }
}
