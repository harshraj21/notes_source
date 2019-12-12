package com.hax.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About US");
        getSupportActionBar().hide();

        Bundle bundle = getIntent().getExtras();
        String abt = bundle.getString("abt");

        webView = findViewById(R.id.aboutwv);

        try {
            webView = new WebView(this);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(abt);
            //webView.addJavascriptInterface(new MyJavascriptInterface(this), "Android");
            setContentView(webView);
        }
        catch (Exception e){
            Toast.makeText(AboutActivity.this, "Something Error",Toast.LENGTH_LONG).show();
        }
    }
}
