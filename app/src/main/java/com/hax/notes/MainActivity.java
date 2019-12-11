package com.hax.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button siGnup,loGin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("NOTES");

        siGnup = findViewById(R.id.signup9);
        loGin = findViewById(R.id.login9);

        siGnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });

        loGin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dotmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.updates){
            Intent i = new Intent(MainActivity.this, UpdateActivity.class);
            startActivity(i);
        }

        if (item.getItemId() == R.id.us){
            Intent i = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(i);
        }

        if(item.getItemId() == R.id.support){
            Intent i = new Intent(MainActivity.this, SupportActivity.class);
            startActivity(i);
        }

        if (item.getItemId() == R.id.exit){
            System.exit(1);
        }

        return super.onOptionsItemSelected(item);
    }
}
