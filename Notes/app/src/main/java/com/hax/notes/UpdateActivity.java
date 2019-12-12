package com.hax.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class UpdateActivity extends AppCompatActivity {

    ProgressDialog bar;
    private String cversion = "1.1";
    TextView cver,sver;
    public Button btn;
    private String sversion;
    WebView webView;
    String durl;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mChildReference = mRootReference.child("Status/version");
    private DatabaseReference mChildReference1 = mRootReference.child("Status/changelog");
    private DatabaseReference mChildReference2 = mRootReference.child("Status/update");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        setTitle("Updates & Changelogs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        webView = findViewById(R.id.clogwv);

        cver = findViewById(R.id.cversion);
        sver = findViewById(R.id.sversion);

        cver.setText("Current Version: " + cversion);
        sver.setText("Server Version: null");

        btn = findViewById(R.id.update);
        btn.setVisibility(View.GONE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cversion.contentEquals(sversion)){
                    Toast.makeText(UpdateActivity.this,"You Are Already Upto Date.",Toast.LENGTH_LONG).show();
                }
                else {
                    if (InternetConnection.checkConnection(UpdateActivity.this)) {
                        new DownladNewVersion().execute();
                    } else {
                        Toast.makeText(UpdateActivity.this, "Please Connect to Internet.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mChildReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //sversion = dataSnapshot.getValue(String.class);
//                sversion = dataSnapshot.getValue(String.class);
//                sver.setText("Server Version: " + sversion);
//                btn.setVisibility(View.VISIBLE);
                durl = dataSnapshot.getValue(String.class);
                //sver.setText("Server Version: " + sversion);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mChildReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //sversion = dataSnapshot.getValue(String.class);
                sversion = dataSnapshot.getValue(String.class);
                sver.setText("Server Version: " + sversion);
                btn.setVisibility(View.VISIBLE);
                //sver.setText("Server Version: " + sversion);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mChildReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //sversion = dataSnapshot.getValue(String.class);
//                sversion = dataSnapshot.getValue(String.class);
//                sver.setText("Server Version: " + sversion);
//                btn.setVisibility(View.VISIBLE);
                //sver.setText("Server Version: " + sversion);
                try {
                    //webView = new WebView(this);
                    //webView.getSettings().setJavaScriptEnabled(true);
                    //webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl(dataSnapshot.getValue(String.class));
                    //webView.addJavascriptInterface(new MyJavascriptInterface(this), "Android");
                    //setContentView(webView);
                }
                catch (Exception e){
                    Toast.makeText(UpdateActivity.this, "Something Error",Toast.LENGTH_LONG).show();
                }
//              ActionBar actionBar = getActionBar();
//              actionBar.setDisplayHomeAsUpEnabled(true);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(UpdateActivity.this, MainActivity.class);
        startActivity(myIntent);
        return true;
    }

    public static class InternetConnection {

        /**
         * CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT
         */
        public static boolean checkConnection(Context context) {
            final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connMgr != null) {
                NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

                if (activeNetworkInfo != null) { // connected to the internet
                    // connected to the mobile provider's data plan
                    if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                        // connected to wifi
                        return true;
                    } else return activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
                }
            }
            return false;
        }
    }

    class DownladNewVersion extends AsyncTask<String,Integer,Boolean>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            bar = new ProgressDialog(UpdateActivity.this);
            bar.setCancelable(false);

            bar.setMessage("Downloading...");

            bar.setIndeterminate(true);
            bar.setCanceledOnTouchOutside(false);
            bar.show();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);

            bar.setIndeterminate(false);
            bar.setMax(100);
            bar.setProgress(progress[0]);
            String msg = "";
            if(progress[0]>99){
                msg = "Finishing...";
            }
            else {
                msg = "Downloading... "+progress[0]+"%";
            }
            bar.setMessage(msg);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            bar.dismiss();

            if(result){
                Toast.makeText(UpdateActivity.this,"Downloaded Successfully\nInstall New Update To Continue",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(UpdateActivity.this,"Error in Download",Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected Boolean doInBackground(String... arg0) {
            Boolean flag = false;

            try {
                URL url = new URL(durl);

                HttpURLConnection c = (HttpURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.setDoOutput(true);
                c.connect();

                String PATH = Environment.getExternalStorageDirectory()+"/Download/";
                File file = new File(PATH);
                file.mkdirs();

                File outputFile = new File(file,"Notes.apk");

                if(outputFile.exists()){
                    outputFile.delete();
                }

                InputStream is = c.getInputStream();

                int size = getFileSize(url);

                byte[] buffer = new byte[1024];
                int len1 = 0;
                int per = 0;
                int downloaded = 0;

                FileOutputStream fos = new FileOutputStream(outputFile);

                while ((len1 = is.read(buffer)) != -1){
                    fos.write(buffer, 0, len1);
                    downloaded += len1;
                    per = (int) (downloaded * 100 / size);
                    publishProgress(per);
                }
                fos.close();
                is.close();

                Thread.sleep(2000);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(FileProvider.getUriForFile(UpdateActivity.this, BuildConfig.APPLICATION_ID + ".provider",new File(PATH + "Notes.apk")),"application/vnd.android.package-archive");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(intent);

                flag = true;
            }
            catch (Exception e){
                Toast.makeText(UpdateActivity.this,"Error: "+e,Toast.LENGTH_SHORT).show();
                flag = false;
            }
            return flag;
        }
    }

    private static int getFileSize(URL url) {
        URLConnection conn = null;
        try {
            conn = url.openConnection();
            if(conn instanceof HttpURLConnection) {
                ((HttpURLConnection)conn).setRequestMethod("HEAD");
            }
            conn.getInputStream();
            return conn.getContentLength();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(conn instanceof HttpURLConnection) {
                ((HttpURLConnection)conn).disconnect();
            }
        }
    }
}
