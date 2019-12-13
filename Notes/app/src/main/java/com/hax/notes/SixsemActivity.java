package com.hax.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class SixsemActivity extends AppCompatActivity {
    String ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixsem);
        setTitle("6th Sem");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        ctx = bundle.getString("ctx");

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (ctx) {
            case "1":
                Intent a = new Intent(SixsemActivity.this, IseActivity.class);
                startActivity(a);
                break;
            case "2":
                Intent b = new Intent(SixsemActivity.this, CseActivity.class);
                startActivity(b);
                break;
            case "3":
                Intent c = new Intent(SixsemActivity.this, EceActivity.class);
                startActivity(c);
                break;
            case "4":
                Intent d = new Intent(SixsemActivity.this, CivActivity.class);
                startActivity(d);
                break;
            case "5":
                Intent e = new Intent(SixsemActivity.this, MechActivity.class);
                startActivity(e);
                break;
            case "6":
                Intent f = new Intent(SixsemActivity.this, EleActivity.class);
                startActivity(f);
                break;
            case "7":
                Intent g = new Intent(SixsemActivity.this, AeroActivity.class);
                startActivity(g);
                break;
        }
        return true;
    }

}
