package com.hax.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class EleActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    GridView gridView;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ele);
        setTitle("Electrical Branch");

        gridView = findViewById(R.id.grid7);

        drawer = findViewById(R.id.drawer_layout7);
        NavigationView navigationView = findViewById(R.id.nav_view7);
        navigationView.setNavigationItemSelectedListener(this);

        mToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<Integer> images = new ArrayList<>();
        List<String> names = new ArrayList<>();

//        images.add(R.drawable.a);
//        images.add(R.drawable.b);
//        images.add(R.drawable.c);
//        images.add(R.drawable.d);
//        images.add(R.drawable.e);
//
//        names.add("Harsh4");
//        names.add("Harsh3");
//        names.add("Harsh2");
//        names.add("Harsh1");
//        names.add("Harsh0");


        NotesAdapter adapter = new NotesAdapter(EleActivity.this, images, names );

        gridView.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.ise:
                Intent a = new Intent(EleActivity.this, IseActivity.class);
                startActivity(a);
                Toast.makeText(EleActivity.this,"Ise Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cse:
                Intent b = new Intent(EleActivity.this, CseActivity.class);
                startActivity(b);
                Toast.makeText(EleActivity.this,"Cse Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.civ:
                Intent c = new Intent(EleActivity.this, CivActivity.class);
                startActivity(c);
                Toast.makeText(EleActivity.this,"Civil Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ece:
                Intent d = new Intent(EleActivity.this, EceActivity.class);
                startActivity(d);
                Toast.makeText(EleActivity.this,"Ece Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.aero:
                Intent e = new Intent(EleActivity.this, AeroActivity.class);
                startActivity(e);
                Toast.makeText(EleActivity.this,"Aeronautical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mech:
                Intent f = new Intent(EleActivity.this, MechActivity.class);
                startActivity(f);
                Toast.makeText(EleActivity.this,"Mechanical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ele:
//                Intent g = new Intent(EleActivity.this, EleActivity.class);
//                startActivity(g);
//                Toast.makeText(EleActivity.this,"Electrical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.acc:
                Intent h = new Intent(EleActivity.this, AccActivity.class);
                startActivity(h);
                Toast.makeText(EleActivity.this,"My Account",Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Intent i = new Intent(EleActivity.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(EleActivity.this,"Logged Out Successfully.",Toast.LENGTH_LONG).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
