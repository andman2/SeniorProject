package com.example.a2018abutler.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (myToolbar != null){
            setSupportActionBar(myToolbar);
            myToolbar.setTitle("Lower Body");

        }
        myToolbar.inflateMenu(R.menu.menu1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//trying to make a menu
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.add:
                intent = new Intent(this, inputActivity.class);
                startActivity(intent);
                return true;

            case R.id.home:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return false;//super.onOptionsItemSelected(item);

        }
    }
    public void switchActivity(int x){//this method allows us to switch activities (pass 0 for lower body and anything else for upper)
        Intent intent;
        intent = new Intent(this, DisplayLift.class);
        intent.putExtra("liftnum", x);
        startActivity(intent);
    }
    }

