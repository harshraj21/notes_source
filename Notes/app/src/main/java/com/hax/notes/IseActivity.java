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

public class IseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    GridView gridView;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle mToggle;
    //TextView tv;

    DatabaseReference reference;
    //RecyclerView recyclerView;
    NotesAdapter adapter;
    String x;
    //Double y;
    String[] strings;
    //String a,b,c,d,f,g,h,j,k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ise);
        setTitle("Ise Branch");
        Bundle bundle = getIntent().getExtras();
        String uname = bundle.getString("uname");

        //tv = findViewById(R.id.name);

        NavigationView navigationView = findViewById(R.id.nav_view1);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.name);
        navUsername.setText(uname);

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

        gridView = findViewById(R.id.grid1);
        //y=0.0;

        drawer = findViewById(R.id.drawer_layout1);
        //NavigationView navigationView = findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);

        mToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toast.makeText(IseActivity.this,"Ise Branch",Toast.LENGTH_SHORT).show();


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

        final List<Integer> images = new ArrayList<>();
        final List<String> names = new ArrayList<>();
        final List<String> urls = new ArrayList<>();

//        recyclerView = findViewById(R.id.recvew);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reference = FirebaseDatabase.getInstance().getReference().child("Notes/ise");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    x = dataSnapshot1.getValue(String.class);
                    names.add(getFileNameFromURL(x).replaceAll("[%20.pdf]"," "));
                    images.add(R.drawable.notes);
                    //int z = Integer.valueOf(y.intValue());
                    urls.add(x);
                    //y++;
                    //Toast.makeText(IseActivity.this,y.toString(),Toast.LENGTH_LONG).show();
                }
                strings = new String[urls.size()];
                strings = urls.toArray(strings);
                adapter = new NotesAdapter(IseActivity.this, images, names );

                gridView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent j = new Intent(IseActivity.this, PdfviewActivity.class);
                j.putExtra("url",strings[i]);
                startActivity(j);
//                switch (i) {
//                    case 0:
//                        Intent i = new Intent(IseActivity.this, PdfviewActivity.class);
//                        i.putExtra("url",x);
//                        startActivity(i);
//                        break;
//                    case 1:
//                        Intent i = new Intent(IseActivity.this, PdfviewActivity.class);
//                        i.putExtra("url",x);
//                        startActivity(i);
//                        break;
//                    case 2:
//                        Intent i = new Intent(IseActivity.this, PdfviewActivity.class);
//                        i.putExtra("url",x);
//                        startActivity(i);
//                        break;
//                    case 3:
//                        Intent i = new Intent(IseActivity.this, PdfviewActivity.class);
//                        i.putExtra("url",x);
//                        startActivity(i);
//                        break;
//                    case 4:
//                        Intent i = new Intent(IseActivity.this, PdfviewActivity.class);
//                        i.putExtra("url",x);
//                        startActivity(i);
//                        break;
//                    case 5:
//                        Intent i = new Intent(IseActivity.this, PdfviewActivity.class);
//                        i.putExtra("url",x);
//                        startActivity(i);
//                        break;
//                    case 6:
//                        Intent i = new Intent(IseActivity.this, PdfviewActivity.class);
//                        i.putExtra("url",x);
//                        startActivity(i);
//                        break;
//                    case 7:
//                        Intent i = new Intent(IseActivity.this, PdfviewActivity.class);
//                        i.putExtra("url",x);
//                        startActivity(i);
//                        break;
//                    case  8:
//                        Intent i = new Intent(IseActivity.this, PdfviewActivity.class);
//                        i.putExtra("url",x);
//                        startActivity(i);
//                        break;
//                }
            }
        });

    }

    public static String getFileNameFromURL(String url) {
        if (url == null) {
            return "";
        }
        try {
            URL resource = new URL(url);
            String host = resource.getHost();
            if (host.length() > 0 && url.endsWith(host)) {
                // handle ...example.com
                return "";
            }
        }
        catch(MalformedURLException e) {
            return "";
        }

        int startIndex = url.lastIndexOf('/') + 1;
        int length = url.length();

        // find end index for ?
        int lastQMPos = url.lastIndexOf("%");
        if (lastQMPos == -1) {
            lastQMPos = length;
        }

        // find end index for #
        int lastHashPos = url.lastIndexOf('#');
        if (lastHashPos == -1) {
            lastHashPos = length;
        }

        // calculate the end index
        int endIndex = Math.min(lastQMPos, lastHashPos);
        return url.substring(startIndex, endIndex);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.ise:
//                Intent a = new Intent(IseActivity.this, IseActivity.class);
//                startActivity(a);
                break;
            case R.id.cse:
                Intent b = new Intent(IseActivity.this, CseActivity.class);
                startActivity(b);
                Toast.makeText(IseActivity.this,"Cse Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.civ:
                Intent c = new Intent(IseActivity.this, CivActivity.class);
                startActivity(c);
                Toast.makeText(IseActivity.this,"Civil Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ece:
                Intent d = new Intent(IseActivity.this, EceActivity.class);
                startActivity(d);
                Toast.makeText(IseActivity.this,"Ece Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.aero:
                Intent e = new Intent(IseActivity.this, AeroActivity.class);
                startActivity(e);
                Toast.makeText(IseActivity.this,"Aeronautical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mech:
                Intent f = new Intent(IseActivity.this, MechActivity.class);
                startActivity(f);
                Toast.makeText(IseActivity.this,"Mechanical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ele:
                Intent g = new Intent(IseActivity.this, EleActivity.class);
                startActivity(g);
                Toast.makeText(IseActivity.this,"Electrical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.acc:
                Intent h = new Intent(IseActivity.this, AccActivity.class);
                startActivity(h);
                Toast.makeText(IseActivity.this,"My Account",Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Intent i = new Intent(IseActivity.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(IseActivity.this,"Logged Out Successfully.",Toast.LENGTH_LONG).show();
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
