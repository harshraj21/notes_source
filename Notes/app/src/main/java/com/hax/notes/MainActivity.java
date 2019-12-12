package com.hax.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button siGnup,loGin;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mChildReference = mRootReference.child("Status/about");

    String abt;

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
    protected void onStart() {
        super.onStart();

        mChildReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //sversion = dataSnapshot.getValue(String.class);
//                sver.setText("Server Version: " + dataSnapshot.getValue(String.class));
//                btn.setVisibility(View.VISIBLE);
                //sver.setText("Server Version: " + sversion);
                abt = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            //Ask the user if they want to quit
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Quit?")
                    .setMessage("Really Wish To Quit")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //Stop the activity
//                            MainActivity.this.finish();
                            System.exit(1);
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();

            return true;
        }
        else {
            return super.onKeyDown(keyCode, event);
        }

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
            i.putExtra("abt",abt);
            startActivity(i);
        }

        if(item.getItemId() == R.id.support){
            Intent i = new Intent(MainActivity.this, SupportActivity.class);
            startActivity(i);
        }

        if (item.getItemId() == R.id.cred){
            Intent i = new Intent(MainActivity.this, CreditsActivity.class);
            startActivity(i);
        }

        if (item.getItemId() == R.id.exit){
            System.exit(1);
        }

        return super.onOptionsItemSelected(item);
    }
}
