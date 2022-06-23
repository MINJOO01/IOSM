package com.cookandroid.toodeole_iosm;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.skt.Tmap.TMapGpsManager;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity implements TMapGpsManager.onLocationChangedCallback{
    String API_Key = "l7xxeb0eaf9d2ad84f4d87f2ad311586b152";
    // T Map View
    TMapView tMapView = null;
    TMapGpsManager tMapGPS = null;
    private List<String> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;
    Bitmap bitmap;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);



        // 리스트를 생성한다.
        list = new ArrayList<String>();

        // 검색에 사용할 데이터을 미리 저장한다.
        settingList();



        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list, this);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);


        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);

            }

            private void search(String charText) {
                // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
                list.clear();

                // 문자 입력이 없을때는 모든 데이터를 보여준다.
                if (charText.length() == 0) {
                    list.addAll(arraylist);
                }
                // 문자 입력을 할때..
                else
                {
                    // 리스트의 모든 데이터를 검색한다.
                    for(int i = 0;i < arraylist.size(); i++)
                    {
                        // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                        if (arraylist.get(i).toLowerCase().contains(charText))
                        {
                            // 검색된 데이터를 리스트에 추가한다.
                            list.add(arraylist.get(i));
                        }
                    }
                }

                // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
                adapter.notifyDataSetChanged();


            }
        });



        // T Map View
        tMapView = new TMapView(this);

        // API Key
        tMapView.setSKTMapApiKey(API_Key);

        // Initial Setting
        tMapView.setZoomLevel(17);
        tMapView.setIconVisibility(true);
        tMapView.setCompassMode(true);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        tMapView.setTrackingMode(true);
        tMapView.setSightVisible(true);

        // T Map View Using Linear Layout
        LinearLayout linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        linearLayoutTmap.addView(tMapView);



        // Request For GPS permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        // GPS using T Map
        tMapGPS = new TMapGpsManager(this);

        // Initial Setting
        tMapGPS.setMinTime(1000);
        tMapGPS.setMinDistance(10);
        tMapGPS.setProvider(tMapGPS.NETWORK_PROVIDER);

        tMapGPS.OpenGps();





        Button btn_type = (Button) findViewById(R.id.btn_type);
        btn_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TypeActivity.class);
                startActivity(intent);
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

        String buildingName1 = "정사부 마라탕";
        TMapMarkerItem tMapMarkerItem1 = new TMapMarkerItem();

        tMapMarkerItem1.setIcon(bitmap);
        tMapMarkerItem1.setTMapPoint(new TMapPoint(36.83143341088353, 127.17566565763053  ));
        tMapMarkerItem1.setName("정사부 마라탕");
        tMapView.addMarkerItem("정사부 마라탕", tMapMarkerItem1);
        tMapMarkerItem1.setCanShowCallout(true);
        tMapMarkerItem1.setCalloutTitle(buildingName1);
        tMapMarkerItem1.setAutoCalloutVisible(false);

        String buildingName2 = "안서반점";
        TMapMarkerItem tMapMarkerItem2 = new TMapMarkerItem();

        tMapMarkerItem2.setIcon(bitmap);
        tMapMarkerItem2.setTMapPoint(new TMapPoint(36.83281665470841, 127.17563519044364));
        tMapMarkerItem2.setName("안서반점");
        tMapView.addMarkerItem("안서반점", tMapMarkerItem2);
        tMapMarkerItem2.setCanShowCallout(true);
        tMapMarkerItem2.setCalloutTitle(buildingName2);
        tMapMarkerItem2.setAutoCalloutVisible(false);

        String buildingName3 = "흥부반점";
        TMapMarkerItem tMapMarkerItem3 = new TMapMarkerItem();

        tMapMarkerItem3.setIcon(bitmap);
        tMapMarkerItem3.setTMapPoint(new TMapPoint(36.8316316150657, 127.17721026056843));
        tMapMarkerItem3.setName("흥부반점");
        tMapView.addMarkerItem("흥부반점", tMapMarkerItem3);
        tMapMarkerItem3.setCanShowCallout(true);
        tMapMarkerItem3.setCalloutTitle(buildingName3);
        tMapMarkerItem3.setAutoCalloutVisible(false);

        String buildingName4 = "하이린";
        TMapMarkerItem tMapMarkerItem4 = new TMapMarkerItem();

        tMapMarkerItem4.setIcon(bitmap);
        tMapMarkerItem4.setTMapPoint(new TMapPoint(36.83143341088353, 127.17566565763053));
        tMapMarkerItem4.setName("하이린");
        tMapView.addMarkerItem("하이린", tMapMarkerItem4);
        tMapMarkerItem4.setCanShowCallout(true);
        tMapMarkerItem4.setCalloutTitle(buildingName4);
        tMapMarkerItem4.setAutoCalloutVisible(false);


        String buildingName5 = "메머드";
        TMapMarkerItem tMapMarkerItem5 = new TMapMarkerItem();

        tMapMarkerItem5.setIcon(bitmap);
        tMapMarkerItem5.setTMapPoint(new TMapPoint(36.8327171770473, 127.1758759771077));
        tMapMarkerItem5.setName("메머드");
        tMapView.addMarkerItem("메머드", tMapMarkerItem5);
        tMapMarkerItem5.setCanShowCallout(true);
        tMapMarkerItem5.setCalloutTitle(buildingName5);
        tMapMarkerItem5.setAutoCalloutVisible(false);


        String buildingName6 = "스타벅스";
        TMapMarkerItem tMapMarkerItem6 = new TMapMarkerItem();

        tMapMarkerItem6.setIcon(bitmap);
        tMapMarkerItem6.setTMapPoint(new TMapPoint(36.82997198761207, 127.17977061876992));
        tMapMarkerItem6.setName("스타벅스");
        tMapView.addMarkerItem("스타벅스", tMapMarkerItem6);
        tMapMarkerItem6.setCanShowCallout(true);
        tMapMarkerItem6.setCalloutTitle(buildingName6);
        tMapMarkerItem6.setAutoCalloutVisible(false);


        String buildingName7 = "핫도그와 쥬스유";
        TMapMarkerItem tMapMarkerItem7 = new TMapMarkerItem();

        tMapMarkerItem7.setIcon(bitmap);
        tMapMarkerItem7.setTMapPoint(new TMapPoint(36.83278007425267, 127.17446927030454));
        tMapMarkerItem7.setName("핫도그와 쥬스유");
        tMapView.addMarkerItem("핫도그와 쥬스유", tMapMarkerItem7);
        tMapMarkerItem7.setCanShowCallout(true);
        tMapMarkerItem7.setCalloutTitle(buildingName7);
        tMapMarkerItem7.setAutoCalloutVisible(false);

        String buildingName8 = "베스킨라빈스";
        TMapMarkerItem tMapMarkerItem8 = new TMapMarkerItem();

        tMapMarkerItem8.setIcon(bitmap);
        tMapMarkerItem8.setTMapPoint(new TMapPoint(36.83119860452101, 127.17753154173099));
        tMapMarkerItem8.setName("베스킨라빈스");
        tMapView.addMarkerItem("베스킨라빈스", tMapMarkerItem8);
        tMapMarkerItem8.setCanShowCallout(true);
        tMapMarkerItem8.setCalloutTitle(buildingName8);
        tMapMarkerItem8.setAutoCalloutVisible(false);

        String buildingName9 = "이디야";
        TMapMarkerItem tMapMarkerItem9 = new TMapMarkerItem();

        tMapMarkerItem9.setIcon(bitmap);
        tMapMarkerItem9.setTMapPoint(new TMapPoint(36.83254309204465, 127.17629595102912));
        tMapMarkerItem9.setName("이디야");
        tMapView.addMarkerItem("이디야", tMapMarkerItem9);
        tMapMarkerItem9.setCanShowCallout(true);
        tMapMarkerItem9.setCalloutTitle(buildingName9);
        tMapMarkerItem9.setAutoCalloutVisible(false);

        String buildingName10 = "소소하며달달한카페";
        TMapMarkerItem tMapMarkerItem10 = new TMapMarkerItem();

        tMapMarkerItem10.setIcon(bitmap);
        tMapMarkerItem10.setTMapPoint(new TMapPoint(36.831543485824135, 127.1773922163157));
        tMapMarkerItem10.setName("소소하며달달한카페");
        tMapView.addMarkerItem("소소하며달달한카페", tMapMarkerItem10);
        tMapMarkerItem10.setCanShowCallout(true);
        tMapMarkerItem10.setCalloutTitle(buildingName10);
        tMapMarkerItem10.setAutoCalloutVisible(false);

        String buildingName11 = "빽다방";
        TMapMarkerItem tMapMarkerItem11 = new TMapMarkerItem();

        tMapMarkerItem11.setIcon(bitmap);
        tMapMarkerItem11.setTMapPoint(new TMapPoint(36.83082682807974, 127.17757832384));
        tMapMarkerItem11.setName("빽다방");
        tMapView.addMarkerItem("빽다방", tMapMarkerItem11);
        tMapMarkerItem11.setCanShowCallout(true);
        tMapMarkerItem11.setCalloutTitle(buildingName11);
        tMapMarkerItem11.setAutoCalloutVisible(false);

        String buildingName12 = "공차";
        TMapMarkerItem tMapMarkerItem12 = new TMapMarkerItem();

        tMapMarkerItem12.setIcon(bitmap);
        tMapMarkerItem12.setTMapPoint(new TMapPoint(36.83063343233083, 127.17885297485863));
        tMapMarkerItem12.setName("공차");
        tMapView.addMarkerItem("공차", tMapMarkerItem12);
        tMapMarkerItem12.setCanShowCallout(true);
        tMapMarkerItem12.setCalloutTitle(buildingName12);
        tMapMarkerItem12.setAutoCalloutVisible(false);

        String buildingName13 = "파리바게트";
        TMapMarkerItem tMapMarkerItem13 = new TMapMarkerItem();

        tMapMarkerItem13.setIcon(bitmap);
        tMapMarkerItem13.setTMapPoint(new TMapPoint(36.83068780189715, 127.17865132752995));
        tMapMarkerItem13.setName("파리바게트");
        tMapView.addMarkerItem("파리바게트", tMapMarkerItem13);
        tMapMarkerItem13.setCanShowCallout(true);
        tMapMarkerItem13.setCalloutTitle(buildingName13);
        tMapMarkerItem13.setAutoCalloutVisible(false);

        String buildingName14 = "봉달주스";
        TMapMarkerItem tMapMarkerItem14 = new TMapMarkerItem();

        tMapMarkerItem14.setIcon(bitmap);
        tMapMarkerItem14.setTMapPoint(new TMapPoint(36.8327171770473, 127.1758759771077));
        tMapMarkerItem14.setName("봉달주스");
        tMapView.addMarkerItem("봉달주스", tMapMarkerItem14);
        tMapMarkerItem14.setCanShowCallout(true);
        tMapMarkerItem14.setCalloutTitle(buildingName14);
        tMapMarkerItem14.setAutoCalloutVisible(false);

        String buildingName15 = "술다락";
        TMapMarkerItem tMapMarkerItem15 = new TMapMarkerItem();

        tMapMarkerItem15.setIcon(bitmap);
        tMapMarkerItem15.setTMapPoint(new TMapPoint(36.83070552204953, 127.17734824537654));
        tMapMarkerItem15.setName("술다락");
        tMapView.addMarkerItem("술다락", tMapMarkerItem15);
        tMapMarkerItem15.setCanShowCallout(true);
        tMapMarkerItem15.setCalloutTitle(buildingName15);
        tMapMarkerItem15.setAutoCalloutVisible(false);

        String buildingName16 = "이쁜이곱창";
        TMapMarkerItem tMapMarkerItem16 = new TMapMarkerItem();

        tMapMarkerItem16.setIcon(bitmap);
        tMapMarkerItem16.setTMapPoint(new TMapPoint(36.83122339324203, 127.1775259941395));
        tMapMarkerItem16.setName("이쁜이곱창");
        tMapView.addMarkerItem("이쁜이곱창", tMapMarkerItem16);
        tMapMarkerItem16.setCanShowCallout(true);
        tMapMarkerItem16.setCalloutTitle(buildingName16);
        tMapMarkerItem16.setAutoCalloutVisible(false);

        String buildingName17 = "안서동야곱집";
        TMapMarkerItem tMapMarkerItem17 = new TMapMarkerItem();

        tMapMarkerItem17.setIcon(bitmap);
        tMapMarkerItem17.setTMapPoint(new TMapPoint(36.83180195282345, 127.17475570208721));
        tMapMarkerItem17.setName("안서동야곱집");
        tMapView.addMarkerItem("안서동야곱집", tMapMarkerItem17);
        tMapMarkerItem17.setCanShowCallout(true);
        tMapMarkerItem17.setCalloutTitle(buildingName17);
        tMapMarkerItem17.setAutoCalloutVisible(false);

        String buildingName18 = "부자전";
        TMapMarkerItem tMapMarkerItem18 = new TMapMarkerItem();

        tMapMarkerItem18.setIcon(bitmap);
        tMapMarkerItem18.setTMapPoint(new TMapPoint(36.83151399472508, 127.17448601234867));
        tMapMarkerItem18.setName("부자전");
        tMapView.addMarkerItem("부자전", tMapMarkerItem18);
        tMapMarkerItem18.setCanShowCallout(true);
        tMapMarkerItem18.setCalloutTitle(buildingName18);
        tMapMarkerItem18.setAutoCalloutVisible(false);

        String buildingName19 = "마이푸드 포장마차 ";
        TMapMarkerItem tMapMarkerItem19 = new TMapMarkerItem();

        tMapMarkerItem19.setIcon(bitmap);
        tMapMarkerItem19.setTMapPoint(new TMapPoint(36.83139234981995, 127.17448293364899));
        tMapMarkerItem19.setName("마이푸드 포장마차 ");
        tMapView.addMarkerItem("마이푸드 포장마차 ", tMapMarkerItem19);
        tMapMarkerItem19.setCanShowCallout(true);
        tMapMarkerItem19.setCalloutTitle(buildingName19);
        tMapMarkerItem19.setAutoCalloutVisible(false);

        String buildingName20 = "봉봉";
        TMapMarkerItem tMapMarkerItem20 = new TMapMarkerItem();

        tMapMarkerItem20.setIcon(bitmap);
        tMapMarkerItem20.setTMapPoint(new TMapPoint(36.83180195282345, 127.17475570208721));
        tMapMarkerItem20.setName("봉봉");
        tMapView.addMarkerItem("봉봉", tMapMarkerItem20);
        tMapMarkerItem20.setCanShowCallout(true);
        tMapMarkerItem20.setCalloutTitle(buildingName20);
        tMapMarkerItem20.setAutoCalloutVisible(false);

        String buildingName21 = "The달콩달콩데이";
        TMapMarkerItem tMapMarkerItem21 = new TMapMarkerItem();

        tMapMarkerItem21.setIcon(bitmap);
        tMapMarkerItem21.setTMapPoint(new TMapPoint(36.831885374935, 127.17470825003383));
        tMapMarkerItem21.setName("The달콩달콩데이");
        tMapView.addMarkerItem("The달콩달콩데이", tMapMarkerItem21);
        tMapMarkerItem21.setCanShowCallout(true);
        tMapMarkerItem21.setCalloutTitle(buildingName21);
        tMapMarkerItem21.setAutoCalloutVisible(false);

        String buildingName22 = "무모한초밥";
        TMapMarkerItem tMapMarkerItem22 = new TMapMarkerItem();

        tMapMarkerItem22.setIcon(bitmap);
        tMapMarkerItem22.setTMapPoint(new TMapPoint(36.83140787670413, 127.17768896200867));
        tMapMarkerItem22.setName("무모한초밥");
        tMapView.addMarkerItem("무모한초밥", tMapMarkerItem22);
        tMapMarkerItem22.setCanShowCallout(true);
        tMapMarkerItem22.setCalloutTitle(buildingName22);
        tMapMarkerItem22.setAutoCalloutVisible(false);

        String buildingName23 = "한신우동";
        TMapMarkerItem tMapMarkerItem23 = new TMapMarkerItem();

        tMapMarkerItem23.setIcon(bitmap);
        tMapMarkerItem23.setTMapPoint(new TMapPoint(36.83103982763209, 127.17674649500144));
        tMapMarkerItem23.setName("한신우동");
        tMapView.addMarkerItem("한신우동", tMapMarkerItem23);
        tMapMarkerItem23.setCanShowCallout(true);
        tMapMarkerItem23.setCalloutTitle(buildingName23);
        tMapMarkerItem23.setAutoCalloutVisible(false);

        String buildingName24 = "호서왕돈가스";
        TMapMarkerItem tMapMarkerItem24 = new TMapMarkerItem();

        tMapMarkerItem24.setIcon(bitmap);
        tMapMarkerItem24.setTMapPoint(new TMapPoint(36.83061516986808, 127.17901266985889));
        tMapMarkerItem24.setName("호서왕돈가스");
        tMapView.addMarkerItem("호서왕돈가스", tMapMarkerItem24);
        tMapMarkerItem24.setCanShowCallout(true);
        tMapMarkerItem24.setCalloutTitle(buildingName24);
        tMapMarkerItem24.setAutoCalloutVisible(false);

        String buildingName25 = "돈가스마을";
        TMapMarkerItem tMapMarkerItem25 = new TMapMarkerItem();

        tMapMarkerItem25.setIcon(bitmap);
        tMapMarkerItem25.setTMapPoint(new TMapPoint(36.832460318123424, 127.17437606233065));
        tMapMarkerItem25.setName("돈가스마을");
        tMapView.addMarkerItem("돈가스마을", tMapMarkerItem25);
        tMapMarkerItem25.setCanShowCallout(true);
        tMapMarkerItem25.setCalloutTitle(buildingName25);
        tMapMarkerItem25.setAutoCalloutVisible(false);

        String buildingName26 = "피플";
        TMapMarkerItem tMapMarkerItem26 = new TMapMarkerItem();

        tMapMarkerItem26.setIcon(bitmap);
        tMapMarkerItem26.setTMapPoint(new TMapPoint(36.832233297981034, 127.17707993220625));
        tMapMarkerItem26.setName("피플");
        tMapView.addMarkerItem("피플", tMapMarkerItem26);
        tMapMarkerItem26.setCanShowCallout(true);
        tMapMarkerItem26.setCalloutTitle(buildingName26);
        tMapMarkerItem26.setAutoCalloutVisible(false);

        String buildingName27 = "봉달주스";
        TMapMarkerItem tMapMarkerItem27 = new TMapMarkerItem();

        tMapMarkerItem27.setIcon(bitmap);
        tMapMarkerItem27.setTMapPoint(new TMapPoint(36.8327171770473, 127.1758759771077));
        tMapMarkerItem27.setName("봉달주스");
        tMapView.addMarkerItem("봉달주스", tMapMarkerItem27);
        tMapMarkerItem27.setCanShowCallout(true);
        tMapMarkerItem27.setCalloutTitle(buildingName27);
        tMapMarkerItem27.setAutoCalloutVisible(false);

        String buildingName28 = "서브밀";
        TMapMarkerItem tMapMarkerItem28 = new TMapMarkerItem();

        tMapMarkerItem28.setIcon(bitmap);
        tMapMarkerItem28.setTMapPoint(new TMapPoint(36.832816613306925, 127.17566321527823));
        tMapMarkerItem28.setName("서브밀");
        tMapView.addMarkerItem("서브밀", tMapMarkerItem28);
        tMapMarkerItem28.setCanShowCallout(true);
        tMapMarkerItem28.setCalloutTitle(buildingName28);
        tMapMarkerItem28.setAutoCalloutVisible(false);

        String buildingName29 = "코코스낵";
        TMapMarkerItem tMapMarkerItem29 = new TMapMarkerItem();

        tMapMarkerItem29.setIcon(bitmap);
        tMapMarkerItem29.setTMapPoint(new TMapPoint(36.83116100965179, 127.17706064620884));
        tMapMarkerItem29.setName("코코스낵");
        tMapView.addMarkerItem("코코스낵", tMapMarkerItem29);
        tMapMarkerItem29.setCanShowCallout(true);
        tMapMarkerItem29.setCalloutTitle(buildingName29);
        tMapMarkerItem5.setAutoCalloutVisible(false);

        String buildingName30 = "깨돌이 김밥";
        TMapMarkerItem tMapMarkerItem30 = new TMapMarkerItem();

        tMapMarkerItem30.setIcon(bitmap);
        tMapMarkerItem30.setTMapPoint(new TMapPoint(36.83082467993529, 127.17750825837052));
        tMapMarkerItem30.setName("깨돌이 김밥");
        tMapView.addMarkerItem("깨돌이 김밥", tMapMarkerItem30);
        tMapMarkerItem30.setCanShowCallout(true);
        tMapMarkerItem30.setCalloutTitle(buildingName30);
        tMapMarkerItem30.setAutoCalloutVisible(false);

        String buildingName31 = "돈가스스쿨";
        TMapMarkerItem tMapMarkerItem31 = new TMapMarkerItem();

        tMapMarkerItem31.setIcon(bitmap);
        tMapMarkerItem31.setTMapPoint(new TMapPoint(36.83296968495207, 127.17574203523036));
        tMapMarkerItem31.setName("돈가스스쿨");
        tMapView.addMarkerItem("돈가스스쿨", tMapMarkerItem31);
        tMapMarkerItem31.setCanShowCallout(true);
        tMapMarkerItem31.setCalloutTitle(buildingName31);
        tMapMarkerItem31.setAutoCalloutVisible(false);












    }

    private void settingList() {
            list.add("서브밀");
            list.add("호호맛집");
            list.add("별이네 밥집");
            list.add("수업이 끝난 오후");
            list.add("봉달주스");
            list.add("맘모스");
            list.add("돈가스스쿨");
            list.add("이삭토스트");
            list.add("이디야");
            list.add("봉구스밥버거");
            list.add("숟가락젓가락");
            list.add("한솥");
            list.add("피플");
            list.add("옹달샘");
            list.add("모야모야");
            list.add("하이린");
            list.add("풍류");
            list.add("투다리");
            list.add("돈가스마을");
            list.add("페리카나");
            list.add("핫도그와 쥬스유");
            list.add("안서동야곱집");
            list.add("월광");
            list.add("소소하며달달한카페");
            list.add("흥부반점");
            list.add("BHC");
            list.add("대학로 참새방");
            list.add("원조부안집");
            list.add("한가득 순대국밥");
            list.add("봉봉");
            list.add("The달콩달콩데이");
            list.add("부자전");
            list.add("맛있네");
            list.add("마푸이드 포장마차");
            list.add("정사부마라탕");
            list.add("네네치킨");
            list.add("놀러와 훈's닭");
            list.add("M.T룸포차");
            list.add("안서동3층");
            list.add("무한리필");
            list.add("한신우동");
            list.add("이디야");
            list.add("깻잎두마리치킨");
            list.add("코코스낵");
            list.add("롯데리아");
            list.add("베스킨라빈스");
            list.add("이쁜이곱창");
            list.add("옥상으로");
            list.add("무모한초밥");
            list.add("기.똥.찬");
            list.add("쌍용식당");
            list.add("말자싸롱");
            list.add("이지향");
            list.add("오다가다");
            list.add("훌랄라 숯불치킨");
            list.add("안서한우국밥분식");
            list.add("스타벅스");
            list.add("쉐프밥버거");
            list.add("안서반점");
            list.add("호서왕돈가스");
            list.add("공차");
            list.add("파리바게트");
            list.add("삼구포차");
            list.add("수원화로구이");
            list.add("Cafe gate");
            list.add("역전할머니맥주");
            list.add("빽다방");
            list.add("깨돌이 김밥");
            list.add("술다락");
            list.add("52도");
            list.add("이슬목장");
            list.add("피자스쿨");
            list.add("JJ's Mellow Tea-food CAFE");
        }


    @Override
    public void onLocationChange(Location location) {
        tMapView.setLocationPoint(location.getLongitude(), location.getLatitude());
        tMapView.setCenterPoint(location.getLongitude(), location.getLatitude());
    }


}
