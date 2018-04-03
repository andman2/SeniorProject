package com.example.a2018abutler.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LowerBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_body);
        ImageButton squat = (ImageButton) findViewById(R.id.Squat);//image button to go to activity which displays lift stats
        ImageButton dead = (ImageButton) findViewById(R.id.Deadlift);
        ImageButton calf = (ImageButton) findViewById(R.id.calf_raises);
        ImageButton clean = (ImageButton) findViewById(R.id.power_clean);
        ImageButton lunge = (ImageButton) findViewById(R.id.weighted_walking_lunge);
        ImageButton leg_press = (ImageButton) findViewById(R.id.Leg_press);
        squat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(6);
            }

        });
        dead.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(7);
            }

        });
        calf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(8);
            }

        });
        clean.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(9);
            }

        });
        lunge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(10);
            }

        });
        leg_press.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(11);
            }

        });
    }
    public void switchActivity(int x){//this method allows us to switch activities (pass 0 for lower body and anything else for upper)
        Intent intent;
        intent = new Intent(this, DisplayLift.class);
        intent.putExtra("liftnum", x);
        startActivity(intent);
    }
    }

