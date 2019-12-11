package com.hax.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    EditText emailId, password, password2;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("SIGNUP");

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.uname3);
        password = findViewById(R.id.pass3);
        password2 = findViewById(R.id.pass4);
        btnSignUp = findViewById(R.id.button2);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass2 = password2.getText().toString();
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if(email.isEmpty()){
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(SignupActivity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    if(pass2.length()<6 && pwd.length()<6){
                        password.setError("Password should be greater than 6 character");
                        password.requestFocus();
                    }
                    else if(pass2.contentEquals(pwd)){
                        progressDialog = ProgressDialog.show(SignupActivity.this,"Signing up","Please Wait.",true,false);
                        try {
                            mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful()){
                                        Toast.makeText(SignupActivity.this,"SignUp Unsuccessful, Please Try Again\nTip: Uses Proper Email Id",Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(SignupActivity.this,"Registered Successfully!\nPlease Login Now!",Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(SignupActivity.this,MainActivity.class));
                                    }
                                    progressDialog.dismiss();
                                }
                            });
                        }
                        catch (Error e){
                            Toast.makeText(SignupActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        password.setError("Password Does not Match!");
                        password.requestFocus();
                    }
                }
                else{
                    Toast.makeText(SignupActivity.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
