package com.example.agath.eseoapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class DisplayinformationESEOActivity extends AppCompatActivity {
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayinformation_eseo);
        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("http://www.eseo.fr/a-propos-de-l-eseo/");

        /*WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/page.html");*/

        /*final TextView textView = (TextView) findViewById(R.id.textView);

        final InputStream stream = getResources().openRawResource(R.raw.content);

        final String text;
        try{
            text = IOUtils.toString(stream);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        textView.setText(Html.fromHtml(text));*/

    }

}
