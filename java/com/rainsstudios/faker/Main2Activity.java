package com.rainsstudios.faker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {
    WebView web;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0500R.layout.activity_main2);
        this.web = (WebView) findViewById(C0500R.id.webview);
        this.web.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSe6IGDfY0vnPURXRspXGF8eBZhI-T_GyO-TeVBQUhDZlLnqPQ/viewform?usp=sf_link");
        this.web.getSettings().setJavaScriptEnabled(true);
    }
}
