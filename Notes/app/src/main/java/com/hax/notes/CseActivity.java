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

public class CseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
        setContentView(R.layout.activity_cse);
        setTitle("Cse Branch");
//        Bundle bundle = getIntent().getExtras();
//        String uname = bundle.getString("uname");

        //tv = findViewById(R.id.name);

        NavigationView navigationView = findViewById(R.id.nav_view2);
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

        gridView = findViewById(R.id.grid2);
//        z=0.0;

        drawer = findViewById(R.id.drawer_layout2);
        //NavigationView navigationView = findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);

        mToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toast.makeText(CseActivity.this,"Cse Branch",Toast.LENGTH_SHORT).show();


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
        //final List<String> urls = new ArrayList<>();

//        recyclerView = findViewById(R.id.recvew);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reference = FirebaseDatabase.getInstance().getReference().child("Notes/cse");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //List<String> td = (ArrayList<String>) dataSnapshot.getValue();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    //x = dataSnapshot1.getValue(String.class);
                    y = dataSnapshot1.getKey();
                    //y = dataSnapshot1;
//                    names.add(getFileNameFromURL(x).replaceAll("[%20.pdf]"," "));
                    names.add(y);
                    images.add(R.drawable.folder);
                    //int z = Integer.valueOf(y.intValue());
                    //urls.add(x);
                    //y++;
//                    Toast.makeText(IseActivity.this,x,Toast.LENGTH_LONG).show();
                }
                //strings = new String[urls.size()];
                //strings = urls.toArray(strings);

                adapter = new NotesAdapter(CseActivity.this, images, names );

//                string2 = new String[td.size()];
//                string2 = td.toArray(string2);

//                Toast.makeText(IseActivity.this,string2[0],Toast.LENGTH_LONG).show();

                gridView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//             Intent j = new Intent(IseActivity.this, PdfviewActivity.class);
//             //j.putExtra("url",strings[i]);
//             startActivity(j);
                switch (i) {
                    case 0:
                        Intent j = new Intent(CseActivity.this, thsemActivity.class);
                        j.putExtra("ctx","2");
                        startActivity(j);
                        break;
                    case 1:
                        Intent k = new Intent(CseActivity.this, fursemActivity.class);
                        k.putExtra("ctx","2");
                        startActivity(k);
                        break;
                    case 2:
                        Intent m = new Intent(CseActivity.this, fifsemActivity.class);
                        m.putExtra("ctx","2");
                        startActivity(m);
                        break;
                    case 3:
                        Intent n = new Intent(CseActivity.this, SixsemActivity.class);
                        n.putExtra("ctx","2");
                        startActivity(n);
                        break;
                    case 4:
                        Intent o = new Intent(CseActivity.this, SevsemActivity.class);
                        o.putExtra("ctx","2");
                        startActivity(o);
                        break;
                    case 5:
                        Intent p = new Intent(CseActivity.this, EighsemActivity.class);
                        p.putExtra("ctx","2");
                        startActivity(p);
                        break;
                }

            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.ise:
                Intent a = new Intent(CseActivity.this, IseActivity.class);
                startActivity(a);
                Toast.makeText(CseActivity.this,"Ise Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cse:
//                Intent b = new Intent(CseActivity.this, CseActivity.class);
//                startActivity(b);
//                Toast.makeText(CseActivity.this,"Cse Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.civ:
                Intent c = new Intent(CseActivity.this, CivActivity.class);
                startActivity(c);
                Toast.makeText(CseActivity.this,"Civil Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ece:
                Intent d = new Intent(CseActivity.this, EceActivity.class);
                startActivity(d);
                Toast.makeText(CseActivity.this,"Ece Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.aero:
                Intent e = new Intent(CseActivity.this, AeroActivity.class);
                startActivity(e);
                Toast.makeText(CseActivity.this,"Aeronautical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mech:
                Intent f = new Intent(CseActivity.this, MechActivity.class);
                startActivity(f);
                Toast.makeText(CseActivity.this,"Mechanical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ele:
                Intent g = new Intent(CseActivity.this, EleActivity.class);
                startActivity(g);
                Toast.makeText(CseActivity.this,"Electrical Branch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.acc:
                Intent h = new Intent(CseActivity.this, AccActivity.class);
                startActivity(h);
                Toast.makeText(CseActivity.this,"My Account",Toast.LENGTH_SHORT).show();
                break;
            case R.id.fre:
                Intent k = new Intent(CseActivity.this, FresherActivity.class);
                startActivity(k);
                Toast.makeText(CseActivity.this,"Freshers",Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                Intent i = new Intent(CseActivity.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(CseActivity.this,"Logged Out Successfully.",Toast.LENGTH_LONG).show();
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
