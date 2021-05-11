package com.example.mission_of_joy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login_Activity extends AppCompatActivity {

    Button signin, signup;

    TextInputLayout username_var, Pwd_var;

//    public void onclick(View v) {
//
//        String username_ = username_var.getEditText().getText().toString();
//        String password_ = Pwd_var.getEditText().getText().toString();
//
//        if (!username_.isEmpty()) {
//            username_var.setError(null);
//            username_var.setErrorEnabled(false);
//            if (!password_.isEmpty()) {
//                Pwd_var.setError(null);
//                Pwd_var.setErrorEnabled(false);
//
//
//                final String username_data = username_var.getEditText().getText().toString();
//                final String password_data = Pwd_var.getEditText().getText().toString();
//
//
//                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//                DatabaseReference databaseReference = firebaseDatabase.getReference("datauser");
//
//                Query check_username = databaseReference.orderByChild("name").equalTo(username_data);
//
//                check_username.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            username_var.setError(null);
//                            username_var.setErrorEnabled(false);
//                            String passwordcheck = snapshot.child(username_data).child("password").getValue(String.class);
//                            if (passwordcheck.equals(password_data)) {
//                                Pwd_var.setError(null);
//                                Pwd_var.setErrorEnabled(false);
//                                Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
//                                Intent login = new Intent(getApplicationContext(), Home_Page.class);
//                                startActivity(login);
//                                finish();
//
//                            } else {
//                                Pwd_var.setError("Wrong Password");
//                            }
//
//                        } else {
//                            username_var.setError("User does not exists");
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//
//            } else {
//                Pwd_var.setError("Please Enter the Password");
//            }
//
//        } else {
//            username_var.setError("Please Enter the username");
//        }
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_);


        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);

        username_var = findViewById(R.id.username);
        Pwd_var = findViewById(R.id.Pwd);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username_ = username_var.getEditText().getText().toString();
                String password_ = Pwd_var.getEditText().getText().toString();

                if (!username_.isEmpty()) {
                    username_var.setError(null);
                    username_var.setErrorEnabled(false);
                    if (!password_.isEmpty()) {
                        Pwd_var.setError(null);
                        Pwd_var.setErrorEnabled(false);


                        final String username_data = username_var.getEditText().getText().toString();
                        final String password_data = Pwd_var.getEditText().getText().toString();


                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference = firebaseDatabase.getReference("datauser");

                        Query check_username = databaseReference.orderByChild("name").equalTo(username_data);

                        check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()) {
                                    username_var.setError(null);
                                    username_var.setErrorEnabled(false);
                                    String passwordcheck = snapshot.child(username_data).child("password").getValue(String.class);
                                    if (passwordcheck.equals(password_data)) {
                                        Pwd_var.setError(null);
                                        Pwd_var.setErrorEnabled(false);
                                        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                                        Intent login = new Intent(getApplicationContext(), Home_Page.class);
                                        startActivity(login);
                                        finish();

                                    } else {
                                        Pwd_var.setError("Wrong Password");
                                    }

                                } else {
                                    username_var.setError("User does not exists");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                    } else {
                        Pwd_var.setError("Please Enter the Password");
                    }

                } else {
                    username_var.setError("Please Enter the username");
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent register = new Intent(getApplicationContext(), signup.class);
                startActivity(register);
            }
        });
    }
}

