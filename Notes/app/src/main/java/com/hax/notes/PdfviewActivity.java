package com.hax.notes;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfviewActivity extends AppCompatActivity {

    PDFView pdfView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview);
        setTitle("Notes Viewer");
        getSupportActionBar().hide();

        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");

        progressBar = findViewById(R.id.progressBar2);

        pdfView = findViewById(R.id.pdfview);
        new RetrivaPDFStream().execute(url);
    }

    class RetrivaPDFStream extends AsyncTask<String, Void, InputStream>{

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                if(urlConnection.getResponseCode() == 200){
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            }
            catch (IOException e){
                return null;
            }

            return inputStream;
        }

        protected void onPostExecute(InputStream inputStream){
            pdfView.fromStream(inputStream).load();
            progressBar.setVisibility(View.GONE);
        }
    }

}
