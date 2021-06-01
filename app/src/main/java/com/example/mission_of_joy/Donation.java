package com.example.mission_of_joy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Donation extends AppCompatActivity {

    private Button Food, Clothes, Money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);


        Food = findViewById(R.id.Food);
        Food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent(getApplicationContext(), Food.class);
                startActivity(categoryIntent);
                finish();

            }
        });

        Clothes = findViewById(R.id.Clothes);
        Clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent(getApplicationContext(), Clothes.class);
                startActivity(categoryIntent);
                finish();

            }
        });

        Money = findViewById(R.id.Money);
        Money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent(getApplicationContext(), Money.class);
                startActivity(categoryIntent);
                finish();

            }
        });

    }
}