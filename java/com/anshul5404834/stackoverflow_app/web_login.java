package com.anshul5404834.stackoverflow_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class web_login extends AppCompatActivity   {
    HttpURLConnection connection;
    URL url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_login);
        try { url= new URL("https://stackexchange.com/oauth/dialog?client_id=14859&scope=private_info&redirect_uri=https://stackexchange.com/oauth/login_success");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        WebView webView=findViewById(R.id.login);
        webView.loadUrl(String.valueOf(url));
        Log.e("webView_login", "onCreate "+webView.getUrl() );
        webView.canGoForward();
    }

}
