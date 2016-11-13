package com.example.agath.eseoapplication;

import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by agath on 07/11/2016.
 */

public class HTMLAsyncTask extends AsyncTask<String, Void, Document> {
    interface DocumentConsumer {
        void setHTMLDocument(Document document);
    }

    private DocumentConsumer _consumer;

    public HTMLAsyncTask (DocumentConsumer consumer){
        _consumer = consumer;
    }

    @Override
    protected Document doInBackground(String... params){
        try {
            Thread.sleep(1000);

            URL url = new URL(params[0]);

            Document doc = Jsoup.connect("http://www.eseo.fr/formations/options-technologiques/").get();
            String title = doc.title();

            return doc;

        }
        catch (InterruptedException ex) {
            Log.e("XMLAsyncTask", "Interrupted");
            return null;
        }
        catch (Exception ex) {
            Log.e("XMLAsyncTask", "Exception while downloading", ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void onPostExecute(Document result) {
        Log.e("XMLAsyncTask", "Finished");
        _consumer.setHTMLDocument(result);
    }
}
