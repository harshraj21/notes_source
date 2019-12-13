package com.hax.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AccActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    GridView gridView;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle mToggle;
    //TextView tv;

    DatabaseReference reference;
    //RecyclerView recyclerView;
    NotesAdapter adapter;
    String y;
//    Double z;
//    String[] strings;
    //String a,b,c,d,f,g,h,j,k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);
        setTitle("My Profile");
//        Bundle bundle = getIntent().getExtras();
//        String uname = bundle.getString("uname");

        //tv = findViewById(R.id.name);

        NavigationView navigationView = findViewById(R.id.nav_view8);
        //View headerView = navigationView.getHeaderView(0);
        //TextView navUsername = headerView.findViewById(R.id.name);
//        navUsername.setText(uname);

        //tv.setText(uname);


//        a="https://github.com/harshraj21/Notes/raw/master/Dms%20mse%203.pdf";
//        b="https://github.com/harshraj21/Notes/raw/master/Graph%20theory%20notes(Mohan%20sir).pdf";
//        c="https://github.com/harshraj21/Notes/raw/master/dms-bounds.pdf";
//        d="https://github.com/harshraj21/Notes/raw/master/dms-graphTH.pdf";
//        f="https://github.com/harshraj21/Notes/raw/master/dms-isomorphism.pdf";
//        g="https://github.com/harshraj21/Notes/raw/master/dms-sets.pdf";
//        h="https://github.com/harshraj21/Notes/raw/master/dms-unit-1.pdf";
//        j="https://github.com/harshraj21/Notes/raw/master/dms.pdf";
//        k="https://github.com/harshraj21/Notes/raw/master/CO_Notes.pdf";

//        gridView = findViewById(R.id.grid9);
////        z=0.0;
//
        drawer = findViewById(R.id.drawer_layout8);
//        NavigationView navigationView = findViewById(R.id.nav_view8);
        navigationView.setNavigationItemSelectedListener(this);
//
        mToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Toast.makeText(CseActivity.this,"Cse Branch",Toast.LENGTH_SHORT).show();


//        List<Integer> images = new ArrayList<>();
//        List<String> names = new ArrayList<>();

//        images.add(R.drawable.notes);
//        images.add(R.drawable.notes);
//        images.add(R.drawable.notes);
//        images.add(R.drawable.notes);
//        images.add(R.drawable.notes);
//        images.add(R.drawable.notes);
//        images.add(R.drawable.notes);
//        images.add(R.drawable.notes);
//        images.add(R.drawable.notes);
//
//        names.add(getFileNameFromURL(a).replace("%20"," "));
//        names.add(getFileNameFromURL(b).replace("%20"," "));
//        names.add(getFileNameFromURL(c).replace("%20"," "));
//        names.add(getFileNameFromURL(d).replace("%20"," "));
//        names.add(getFileNameFromURL(f).replace("%20"," "));
//        names.add(getFileNameFromURL(g).replace("%20"," "));
//        names.add(getFileNameFromURL(h).replace("%20"," "));
//        names.add(getFileNameFromURL(j).replace("%20"," "));
//        names.add(getFileNameFromURL(k).replace("%20"," "));

//        final List<Integer> images = new ArrayList<>();
//        final List<String> names = new ArrayList<>();
        //final List<String> urls = new ArrayList<>();

//        recyclerView = findViewById(R.id.recvew);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        reference = FirebaseDatabase.getInstance().getReference().child("Notes/civ");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                //List<String> td = (ArrayList<String>) dataSnapshot.getValue();
//                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
//                    //x = dataSnapshot1.getValue(String.class);
//                    y = dataSnapshot1.getKey();
//                    //y = dataSnapshot1;
////                    names.add(getFileNameFromURL(x).replaceAll("[%20.pdf]"," "));
//                    names.add(y);
//                    images.add(R.drawable.folder);
//                    //int z = Integer.valueOf(y.intValue());
//                    //urls.add(x);
//                    //y++;
////                    Toast.makeText(IseActivity.this,x,Toast.LENGTH_LONG).show();
//                }
//                //strings = new String[urls.size()];
//                //strings = urls.toArray(strings);
//
//                adapter = new NotesAdapter(AeroActivity.this, images, names );
//
////                string2 = new String[td.size()];
////                string2 = td.toArray(string2);
//
////                Toast.makeText(IseActivity.this,string2[0],Toast.LENGTH_LONG).show();
//
//                gridView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
////             Intent j = new Intent(IseActivity.this, PdfviewActivity.class);
////             //j.putExtra("url",strings[i]);
////             startActivity(j);
//                switch (i) {
//                    case 0:
//                        Intent j = new Intent(AeroActivity.this, thsemActivity.class);
//                        startActivity(j);
//                        break;
//                    case 1:
//                        Intent k = new Intent(AeroActivity.this, fursemActivity.class);
//                        startActivity(k);
//                        break;
//                    case 2:
//                        Intent m = new Intent(AeroActivity.this, fifsemActivity.class);
//                        startActivity(m);
//                        break;
//                    case 3:
//                        Intent n = new Intent(AeroActivity.this, SixsemActivity.class);
//                        startActivity(n);
//                        break;
//                    case 4:
//                        Intent o = new Intent(AeroActivity.this, SevsemActivity.class);
//                        startActivity(o);
//                        break;
//                    case 5:
//                        Intent p = new Intent(AeroActivity.this, EighsemActivity.class);
//                        startActivity(p);
//                        break;
//                }
//
//            }
//        });
//
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.ise:
                Intent a = new Intent(AccActivity.this, IseActivity.class);
                startActivity(a);
                Toast.makeText(AccActivity.this,"Ise Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cse:
                Intent b = new Intent(AccActivity.this, CseActivity.class);
                startActivity(b);
                Toast.makeText(AccActivity.this,"Cse Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.civ:
                Intent c = new Intent(AccActivity.this, CivActivity.class);
                startActivity(c);
                Toast.makeText(AccActivity.this,"Civil Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ece:
                Intent d = new Intent(AccActivity.this, EceActivity.class);
                startActivity(d);
                Toast.makeText(AccActivity.this,"Ece Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.aero:
                Intent e = new Intent(AccActivity.this, AeroActivity.class);
                startActivity(e);
                Toast.makeText(AccActivity.this,"Aeronautical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mech:
                Intent f = new Intent(AccActivity.this, MechActivity.class);
                startActivity(f);
                Toast.makeText(AccActivity.this,"Mechanical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ele:
                Intent g = new Intent(AccActivity.this, EleActivity.class);
                startActivity(g);
                Toast.makeText(AccActivity.this,"Electrical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.acc:
//                Intent h = new Intent(AccActivity.this, AccActivity.class);
//                startActivity(h);
//                Toast.makeText(AccActivity.this,"My Account",Toast.LENGTH_SHORT).show();
                break;
            case R.id.fre:
                Intent k = new Intent(AccActivity.this, FresherActivity.class);
                startActivity(k);
                Toast.makeText(AccActivity.this,"Freshers",Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                Intent i = new Intent(AccActivity.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(AccActivity.this,"Logged Out Successfully.",Toast.LENGTH_LONG).show();
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
