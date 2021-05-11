package com.example.mission_of_joy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class signup extends AppCompatActivity {

    Button register, login;

    TextInputLayout name_var, Phone_var, email_var, password_var;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//        register = findViewById(R.id.register);
//        login = findViewById(R.id.login);
        name_var = findViewById(R.id.name);
        Phone_var = findViewById(R.id.Phone);
        email_var = findViewById(R.id.signup_email);
        password_var = findViewById(R.id.signup_Pwd);
    }

    public void LoginButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
        startActivity(intent);
        finish();
    }

    public void RegisterButton(View view) {

        String name_ = name_var.getEditText().getText().toString();
        String Phone_ = Phone_var.getEditText().getText().toString();
        String email_ = email_var.getEditText().getText().toString();
        String password_ = password_var.getEditText().getText().toString();

        if (!name_.isEmpty()) {
            name_var.setError(null);
            name_var.setErrorEnabled(false);
            if (!Phone_.isEmpty()) {
                Phone_var.setError(null);
                Phone_var.setErrorEnabled(false);
                if (!email_.isEmpty()) {
                    email_var.setError(null);
                    email_var.setErrorEnabled(false);
                    if (!password_.isEmpty()) {
                        password_var.setError(null);
                        password_var.setErrorEnabled(false);
                        if (email_.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {

                            firebaseDatabase = FirebaseDatabase.getInstance();
                            reference = firebaseDatabase.getReference("datauser");

                            String name_s = name_var.getEditText().getText().toString();
                            String Phone_s = Phone_var.getEditText().getText().toString();
                            String email_s = email_var.getEditText().getText().toString();
                            String password_s = password_var.getEditText().getText().toString();


                            storing_Data storing_Datass = new storing_Data(name_s, Phone_s, email_s, password_s);
                            reference.child(name_s).setValue(storing_Datass);

                            Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(), Home_Page.class);
                            startActivity(intent);
                            finish();


                        } else {
                            email_var.setError("Invalid Email");
                        }
                    } else {
                        password_var.setError("Please Enter Password");
                    }
                } else {
                    email_var.setError("Please Enter Email");
                }

            } else {
                Phone_var.setError("Please Enter Phone Number");
            }

        } else {

            name_var.setError("Please Enter Your Name");

        }


    }
}