package com.example.mission_of_joy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Events extends AppCompatActivity {

    RecyclerView rcv;
    myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        setTitle("Events");

        rcv = (RecyclerView) findViewById(R.id.recview);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new myadapter(dataqueue());
        rcv.setAdapter(adapter);
    }

    public ArrayList<Model> dataqueue() {
        ArrayList<Model> holder = new ArrayList<>();

        Model obj1 = new Model();
        obj1.setHeader("PAINTING COMPETITION");
        obj1.setDesc("APRIL 30,2021 PLACE: PUNE");
        obj1.setImgname(R.drawable.paint);
        holder.add(obj1);


        Model obj2 = new Model();
        obj2.setHeader("DONATE BLOOD");
        obj2.setDesc("MAY 5,2021 PLACE: PUNE");
        obj2.setImgname(R.drawable.blood);
        holder.add(obj2);



        Model obj3 = new Model();
        obj3.setHeader("ORPHAN SPONSORSHIP PROGRAM");
        obj3.setDesc(" MAY 10,2021 PLACE: PUNE");
        obj3.setImgname(R.drawable.sponsor);
        holder.add(obj3);

        Model obj4 = new Model();
        obj4.setHeader("TREE PLANTATION");
        obj4.setDesc(" MAY 15,2021 PLACE: PUNE");
        obj4.setImgname(R.drawable.treeplantation);
        holder.add(obj4);

        Model obj5 = new Model();
        obj5.setHeader("GIFT AN ORPHAN");
        obj5.setDesc("MAY 12,2021 PLACE: PUNE");
        obj5.setImgname(R.drawable.charity);
        holder.add(obj5);

        Model obj6 = new Model();
        obj6.setHeader("SUMMER GAMES");
        obj6.setDesc("MAY 29,2021 PLACE: PUNE");
        obj6.setImgname(R.drawable.summergames);
        holder.add(obj6);

        Model obj7 = new Model();
        obj7.setHeader("WINTER CAMPEIGN FOR ORPHANS");
        obj7.setDesc(" MAY 9,2021 PLACE: PUNE");
        obj7.setImgname(R.drawable.winter);
        holder.add(obj7);

        Model obj8 = new Model();
        obj8.setHeader("PERSONALITY DEVELOPMENT TRAINING");
        obj8.setDesc("MAY 25,2021 PLACE: PUNE");
        obj8.setImgname(R.drawable.personalitydevelopment);
        holder.add(obj8);


        Model obj9 = new Model();
        obj9.setHeader("WORLD ORPHAN DAY");
        obj9.setDesc("APRIL 20,2021 PLACE: PUNE");
        obj9.setImgname(R.drawable.orphanday);
        holder.add(obj9);

        return holder;
    }


}