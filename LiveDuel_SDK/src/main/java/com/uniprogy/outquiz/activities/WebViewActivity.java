package com.uniprogy.outquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.uniprogy.outquiz.R;

public class WebViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        Intent intent = getIntent();
        String docTitle = intent.getStringExtra("docTitle");
        String docUrl = intent.getStringExtra("docUrl");

        setTitle(docTitle);
        webView.loadUrl(docUrl);

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onNavigateUp()
    {
        finish();
        return true;
    }
}
