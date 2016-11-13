package com.example.agath.eseoapplication;

import java.io.IOException;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayConnexionActivity extends Activity {

    // URL Address
    String url = "http://www.eseo.fr/a-propos-de-l-eseo/fier-d-etre-ingenieur-eseo/actualites/";
    ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_connexion);


        //new Title().execute();
        new Description().execute();


    }

    // Title AsyncTask
    private class Title extends AsyncTask<Void, Void, Void> {
        String title;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(DisplayConnexionActivity.this);
            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Document document = Jsoup.connect(url).get();
                // Using Elements to get the Meta data
                Elements description = document
                        .select("title");
                // Locate the content attribute
                title = description.text();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set title into TextView
            TextView txttitle = (TextView) findViewById(R.id.titletxt);
            txttitle.setText(title);
            mProgressDialog.dismiss();
        }
    }

    // Description AsyncTask
    private class Description extends AsyncTask<Void, Void, Void> {
        String actu, desc;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(DisplayConnexionActivity.this);
            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Document document = Jsoup.connect(url).get();
                // Using Elements to get the Meta data
                Elements description = document.select("div.newsContainer");
                // Locate the content attribute
                actu = description.select("h2").first().text();
                desc = description.select("div.description").first().text();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView
            TextView txttitle = (TextView) findViewById(R.id.titletxt);
            txttitle.setText(actu);
            TextView txtdesc = (TextView) findViewById(R.id.desctxt);
            txtdesc.setText(desc);
            mProgressDialog.dismiss();
        }
    }
}