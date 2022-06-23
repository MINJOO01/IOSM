package com.cookandroid.toodeole_iosm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class School2Activity extends AppCompatActivity {

    Button map_btn4;
    Button building_a;
    Button building_b;
    Button building_c;
    Button building_d;
    Button building_e;
    Button building_f;
    Button building_h;
    Button building_i;
    Button building_k;
    Button building_l;
    Button building_n;
    Button building_s;
    Button building_v;
    Button building_w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school2);

        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        Button foodButton = (Button) findViewById(R.id.foodButton);
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FoodActivity.class);
                startActivity(intent);
            }
        });



        Button schoolButton = (Button) findViewById(R.id.schoolButton);
        schoolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SchoolActivity.class);
                startActivity(intent);
            }
        });

        Button studentButton = (Button) findViewById(R.id.studentButton);
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                startActivity(intent);
            }
        });

        Button myPageButton = (Button) findViewById(R.id.myPageButton);
        myPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(intent);
            }
        });

        Button homeWorkButton = (Button) findViewById(R.id.homeWorkButton);
        homeWorkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeworkActivity.class);
                startActivity(intent);
            }
        });

        map_btn4 = findViewById(R.id.map_btn4);
        building_a = findViewById(R.id.building_a);
        building_b = findViewById(R.id.building_b);
        building_c = findViewById(R.id.building_c);
        building_d = findViewById(R.id.building_d);
        building_e = findViewById(R.id.building_e);
        building_f = findViewById(R.id.building_f);
        building_h = findViewById(R.id.building_h);
        building_i = findViewById(R.id.building_i);
        building_k = findViewById(R.id.building_k);
        building_l = findViewById(R.id.building_l);
        building_n = findViewById(R.id.building_n);
        building_s = findViewById(R.id.building_s);
        building_v = findViewById(R.id.building_v);
        building_w = findViewById(R.id.building_w);

       // getSupportActionBar().setIcon(R.drawable.img1);
      //  getSupportActionBar().setDisplayUseLogoEnabled(true);
       // getSupportActionBar().setDisplayShowHomeEnabled(true);

        map_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), School3Activity.class);
                startActivity(intent);
            }
        });

        // 버튼 누르면 해당 건물 설명 있는 Activity로 이동

        building_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Building1Activity.class);
                startActivity(intent);
            }
        });

        building_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingeActivity.class);
                startActivity(intent);
            }
        }); //B동은 원래 상록관이 맞지만, 만들던 중 실수로 여기에서는 BuildingeActivity에 B동의 정보가 있음

        building_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingcActivity.class);
                startActivity(intent);
            }
        });

        building_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingdActivity.class);
                startActivity(intent);
            }
        });

        building_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingbActivity.class);
                startActivity(intent);
            }
        }); //E동은 원래 송백관이 맞지만, 만들던 중 실수로 여기에서는 BuildingbActivity에 E동의 정보가 있음

        building_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingfActivity.class);
                startActivity(intent);
            }
        });

        building_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildinghActivity.class);
                startActivity(intent);
            }
        });

        building_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingIActivity.class);
                startActivity(intent);
            }
        });

        building_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingkActivity.class);
                startActivity(intent);
            }
        });

        building_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingLActivity.class);
                startActivity(intent);
            }
        });

        building_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingnActivity.class);
                startActivity(intent);
            }
        });

        building_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingSActivity.class);
                startActivity(intent);
            }
        });

        building_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingVActivity.class);
                startActivity(intent);
            }
        });

        building_w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuildingWActivity.class);
                startActivity(intent);
            }
        });
    }
}