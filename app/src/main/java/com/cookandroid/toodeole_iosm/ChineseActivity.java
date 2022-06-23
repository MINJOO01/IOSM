package com.cookandroid.toodeole_iosm;


import static com.cookandroid.toodeole_iosm.R.id.webView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChineseActivity  extends AppCompatActivity {
    private WebView mWebView;

    private String myUrl = "http://";// 접속 URL (내장HTML의 경우 왼쪽과 같이 쓰고 아니면 걍 URL)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinise);


        ImageButton btn_back = (ImageButton) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TypeActivity.class);
                startActivity(intent);
            }
        });


        Button btn_jung = (Button) findViewById(R.id.btn_jung);
        btn_jung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 웹뷰 셋팅
                mWebView = (WebView) findViewById(webView);//xml 자바코드 연결
                mWebView.getSettings().setJavaScriptEnabled(true);//자바스크립트 허용

                mWebView.loadUrl("https://m.place.naver.com/restaurant/1718025953/home");//웹뷰 실행
                mWebView.setWebChromeClient(new WebChromeClient());//웹뷰에 크롬 사용 허용//이 부분이 없으면 크롬에서 alert가 뜨지 않음
                mWebView.setWebViewClient(new WebViewClientClass());//새창열기 없이 웹뷰 내에서 다시 열기//페이지 이동 원활히 하기위해 사용


            }
        });

        Button btn_anseo = (Button) findViewById(R.id.btn_anseo);
        btn_anseo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 웹뷰 셋팅
                mWebView = (WebView) findViewById(webView);//xml 자바코드 연결
                mWebView.getSettings().setJavaScriptEnabled(true);//자바스크립트 허용

                mWebView.loadUrl("https://m.place.naver.com/restaurant/36868286/home?entry=pll");//웹뷰 실행
                mWebView.setWebChromeClient(new WebChromeClient());//웹뷰에 크롬 사용 허용//이 부분이 없으면 크롬에서 alert가 뜨지 않음
                mWebView.setWebViewClient(new WebViewClientClass());//새창열기 없이 웹뷰 내에서 다시 열기//페이지 이동 원활히 하기위해 사용

            }
        });


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//뒤로가기 버튼 이벤트
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {//웹뷰에서 뒤로가기 버튼을 누르면 뒤로가짐
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {//페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL",url);
            view.loadUrl(url);
            return true;
        }
    }


}
