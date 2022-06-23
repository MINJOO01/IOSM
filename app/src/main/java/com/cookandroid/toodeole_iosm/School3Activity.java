package com.cookandroid.toodeole_iosm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.skt.Tmap.TMapGpsManager;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

public class School3Activity extends AppCompatActivity implements TMapGpsManager.onLocationChangedCallback{

    Button map_btn5;
    Button buttonMove1;
    Button buttonZoomIn;
    Button buttonZoomOut;

    String API_Key = "l7xxeb0eaf9d2ad84f4d87f2ad311586b152"; //발급받은 API Key

    // T Map View
    TMapView tMapView = null;

    // T Map GPS
    TMapGpsManager tMapGPS = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school3);
        map_btn5 = findViewById(R.id.map_btn5);
        Button buttonMove1 = (Button) findViewById(R.id.buttonMove1);
        Button buttonZoomIn = (Button) findViewById(R.id.buttonZoomIn);
        Button buttonZoomOut = (Button) findViewById(R.id.buttonZoomOut);


        // T Map View
        tMapView = new TMapView(this);

        // API Key
        tMapView.setSKTMapApiKey(API_Key);

        // Initial Setting
        tMapView.setZoomLevel(10);
        tMapView.setLocationPoint(36.832680556044544, 127.17626543909823);
        //tMapView.setCenterPoint(36.832680556044544, 127.17626543909823);
        tMapView.setCompassMode(false);
        tMapView.setIconVisibility(true);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        tMapView.setTrackingMode(false);
        tMapView.setSightVisible(false);

        // GPS using T Map
        tMapGPS = new TMapGpsManager(this);

        // Initial Setting
        tMapGPS.setMinTime(1000);
        tMapGPS.setMinDistance(10);
        tMapGPS.setProvider(tMapGPS.NETWORK_PROVIDER);

        tMapGPS.OpenGps();


        // T Map View Using Linear Layout
        LinearLayout linearLayoutTmap = (LinearLayout) findViewById(R.id.linearLayoutTmap);
        linearLayoutTmap.addView(tMapView);

        // [정문] 버튼 클릭 시
        buttonMove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3번째 파라미터 생략 == 지도 이동 Animation 사용안함
                tMapView.setCenterPoint(36.832680556044544, 127.17626543909823);
            }
        });

        // [확대] 버튼 클릭 시
        buttonZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tMapView.MapZoomIn();
            }
        });

        // [축소] 버튼 클릭 시
        buttonZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tMapView.MapZoomOut();
            }
        });

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


        // getSupportActionBar().setIcon(R.drawable.img1);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);


        map_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), School2Activity.class);
                startActivity(intent);
            }
        });


        //T Map 마커 생성

        // Marker img -> bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img6);


        String buildingName1 = "정문";
        String buildingName2 = "A동 청록관";
        String buildingName3 = "B동 상록관";
        String buildingName0 = "C동 본관";
        String buildingName4 = "D동 디자인관";
        String buildingName5 = "E동 송백관";
        String buildingName6 = "F동 종합실기관";
        String buildingName7 = "H동 학생회관";
        String buildingName8 = "I동 한누리관";
        String buildingName9 = "K동 스포츠센터";
        String buildingName10 = "L동 도서관";
        String buildingName11 = "N동 식물과학관";
        String buildingName12 = "S동 계당관";
        String buildingName13 = "V 노천극장";
        String buildingName14 = "W동 기숙사";


        TMapMarkerItem tMapMarkerItem1 = new TMapMarkerItem();
        tMapMarkerItem1.setIcon(bitmap);
        tMapMarkerItem1.setTMapPoint(new TMapPoint(36.832680556044544, 127.17626543909823));
        tMapMarkerItem1.setName("정문");
        tMapView.addMarkerItem("정문", tMapMarkerItem1);
        tMapMarkerItem1.setCanShowCallout(true);
        tMapMarkerItem1.setCalloutTitle(buildingName1);
        tMapMarkerItem1.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem2 = new TMapMarkerItem();
        tMapMarkerItem2.setIcon(bitmap);
        tMapMarkerItem2.setTMapPoint(new TMapPoint(36.83317531404281, 127.17683828544854));
        tMapMarkerItem2.setName("청록관");
        tMapView.addMarkerItem("청록관", tMapMarkerItem2);
        tMapMarkerItem2.setCanShowCallout(true);
        tMapMarkerItem2.setCalloutTitle(buildingName2);
        tMapMarkerItem2.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem3 = new TMapMarkerItem();
        tMapMarkerItem3.setIcon(bitmap);
        tMapMarkerItem3.setTMapPoint(new TMapPoint(36.833454238953145, 127.17711917909172));
        tMapMarkerItem3.setName("상록관");
        tMapView.addMarkerItem("상록관", tMapMarkerItem3);
        tMapMarkerItem3.setCanShowCallout(true);
        tMapMarkerItem3.setCalloutTitle(buildingName3);
        tMapMarkerItem3.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem4 = new TMapMarkerItem();
        tMapMarkerItem4.setIcon(bitmap);
        tMapMarkerItem4.setTMapPoint(new TMapPoint(36.834029941214, 127.17779311527956));
        tMapMarkerItem4.setName("본관");
        tMapView.addMarkerItem("본관", tMapMarkerItem4);
        tMapMarkerItem4.setCanShowCallout(true);
        tMapMarkerItem4.setCalloutTitle(buildingName0);
        tMapMarkerItem4.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem5 = new TMapMarkerItem();
        tMapMarkerItem5.setIcon(bitmap);
        tMapMarkerItem5.setTMapPoint(new TMapPoint(36.83250210268604, 127.18108529754946));
        tMapMarkerItem5.setName("디자인관");
        tMapView.addMarkerItem("디자인관", tMapMarkerItem4);
        tMapMarkerItem5.setCanShowCallout(true);
        tMapMarkerItem5.setCalloutTitle(buildingName4);
        tMapMarkerItem5.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem6 = new TMapMarkerItem();
        tMapMarkerItem6.setIcon(bitmap);
        tMapMarkerItem6.setTMapPoint(new TMapPoint(36.83459448299292, 127.17989073492764));
        tMapMarkerItem6.setName("송백관");
        tMapView.addMarkerItem("송백관", tMapMarkerItem5);
        tMapMarkerItem6.setCanShowCallout(true);
        tMapMarkerItem6.setCalloutTitle(buildingName5);
        tMapMarkerItem6.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem7 = new TMapMarkerItem();
        tMapMarkerItem7.setIcon(bitmap);
        tMapMarkerItem7.setTMapPoint(new TMapPoint(36.83355103299549, 127.18164827384744));
        tMapMarkerItem7.setName("종합실기관");
        tMapView.addMarkerItem("종합실기관", tMapMarkerItem6);
        tMapMarkerItem7.setCanShowCallout(true);
        tMapMarkerItem7.setCalloutTitle(buildingName6);
        tMapMarkerItem7.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem8 = new TMapMarkerItem();
        tMapMarkerItem8.setIcon(bitmap);
        tMapMarkerItem8.setTMapPoint(new TMapPoint(36.833476911448955, 127.18002263885607));
        tMapMarkerItem8.setName("학생회관");
        tMapView.addMarkerItem("학생회관", tMapMarkerItem8);
        tMapMarkerItem8.setCanShowCallout(true);
        tMapMarkerItem8.setCalloutTitle(buildingName7);
        tMapMarkerItem8.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem9 = new TMapMarkerItem();
        tMapMarkerItem9.setIcon(bitmap);
        tMapMarkerItem9.setTMapPoint(new TMapPoint(36.8342263504528, 127.17901547911481));
        tMapMarkerItem9.setName("한누리관");
        tMapView.addMarkerItem("한누리관", tMapMarkerItem9);
        tMapMarkerItem9.setCanShowCallout(true);
        tMapMarkerItem9.setCalloutTitle(buildingName8);
        tMapMarkerItem9.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem10 = new TMapMarkerItem();
        tMapMarkerItem10.setIcon(bitmap);
        tMapMarkerItem10.setTMapPoint(new TMapPoint(36.8324715780398, 127.1804182353345));
        tMapMarkerItem10.setName("스포츠센터");
        tMapView.addMarkerItem("스포츠센터", tMapMarkerItem10);
        tMapMarkerItem10.setCanShowCallout(true);
        tMapMarkerItem10.setCalloutTitle(buildingName9);
        tMapMarkerItem10.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem11 = new TMapMarkerItem();
        tMapMarkerItem11.setIcon(bitmap);
        tMapMarkerItem11.setTMapPoint(new TMapPoint(36.83329935934866, 127.1782510362438));
        tMapMarkerItem11.setName("도서관");
        tMapView.addMarkerItem("도서관", tMapMarkerItem11);
        tMapMarkerItem11.setCanShowCallout(true);
        tMapMarkerItem11.setCalloutTitle(buildingName10);
        tMapMarkerItem11.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem12 = new TMapMarkerItem();
        tMapMarkerItem12.setIcon(bitmap);
        tMapMarkerItem12.setTMapPoint(new TMapPoint(36.83428827673272, 127.17677358620581));
        tMapMarkerItem12.setName("식물과학관");
        tMapView.addMarkerItem("식물과학관", tMapMarkerItem12);
        tMapMarkerItem12.setCanShowCallout(true);
        tMapMarkerItem12.setCalloutTitle(buildingName11);
        tMapMarkerItem12.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem13 = new TMapMarkerItem();
        tMapMarkerItem13.setIcon(bitmap);
        tMapMarkerItem13.setTMapPoint(new TMapPoint(36.83238851283293, 127.17873655398722));
        tMapMarkerItem13.setName("계당관");
        tMapView.addMarkerItem("계당관", tMapMarkerItem13);
        tMapMarkerItem13.setCanShowCallout(true);
        tMapMarkerItem13.setCalloutTitle(buildingName12);
        tMapMarkerItem13.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem14 = new TMapMarkerItem();
        tMapMarkerItem14.setIcon(bitmap);
        tMapMarkerItem14.setTMapPoint(new TMapPoint(36.83367405569072, 127.17775866137568));
        tMapMarkerItem14.setName("노천극장");
        tMapView.addMarkerItem("노천극장", tMapMarkerItem14);
        tMapMarkerItem14.setCanShowCallout(true);
        tMapMarkerItem14.setCalloutTitle(buildingName13);
        tMapMarkerItem14.setAutoCalloutVisible(false);

        TMapMarkerItem tMapMarkerItem15 = new TMapMarkerItem();
        tMapMarkerItem15.setIcon(bitmap);
        tMapMarkerItem15.setTMapPoint(new TMapPoint(36.83462317434047, 127.18176291125967));
        tMapMarkerItem15.setName("기숙사");
        tMapView.addMarkerItem("기숙사", tMapMarkerItem15);
        tMapMarkerItem15.setCanShowCallout(true);
        tMapMarkerItem15.setCalloutTitle(buildingName14);
        tMapMarkerItem15.setAutoCalloutVisible(false);


        //건물안내 버튼 코드
        map_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), School2Activity.class);
                startActivity(intent);
            }

        });

    }
    @Override
    public void onLocationChange(Location location){
        tMapView.setLocationPoint(location.getLongitude(), location.getLatitude());
        tMapView.setCenterPoint(location.getLongitude(), location.getLatitude());
    }

}

