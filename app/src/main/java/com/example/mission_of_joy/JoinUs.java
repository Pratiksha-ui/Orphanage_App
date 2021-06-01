package com.example.mission_of_joy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class JoinUs extends AppCompatActivity {

    TextInputLayout voluntername,Phone_2,Event,ReasonForVolunteering,Experience;
    Button Submit;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_us);

        voluntername=findViewById(R.id.volunteername);
        Phone_2=findViewById(R.id.Phone2);
        Event=findViewById(R.id.Event);
        ReasonForVolunteering=findViewById(R.id.ReasonForVolunteering);
        Experience=findViewById(R.id.Experience);
        Submit=findViewById(R.id.Submit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference= rootNode.getReference("volunteer");

                String VolName = voluntername.getEditText().getText().toString();
                String VolPhone = Phone_2.getEditText().getText().toString();
                String event = Event.getEditText().getText().toString();
                String Reason= ReasonForVolunteering.getEditText().getText().toString();
                String experience= Experience.getEditText().getText().toString();


                Volunteering volunteer  = new Volunteering(VolName,VolPhone,event,Reason,experience);

                reference.child(event).setValue(volunteer);

                Toast.makeText(getApplicationContext(),"Successfully Submitted",Toast.LENGTH_LONG).show();

            }
        });

    }

}
