package com.example.a2018abutler.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class UpperBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper_body);
        ImageButton bench = (ImageButton) findViewById(R.id.Bench);//image button to go to activity which displays lift stats
        ImageButton lat = (ImageButton) findViewById(R.id.latpulldown);
        ImageButton shoulder_press = (ImageButton) findViewById(R.id.shoulder_press);
        ImageButton pec = (ImageButton) findViewById(R.id.Pectoral_flys);
        ImageButton rows = (ImageButton) findViewById(R.id.Bent_over_rows);
        ImageButton curls = (ImageButton) findViewById(R.id.Bicep_curls);
        bench.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(0);
            }

        });
        lat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(1);
            }

        });
        shoulder_press.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(2);
            }

        });
        pec.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(3);
            }

        });
        rows.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(4);
            }

        });
        curls.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(5);
            }

        });
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (myToolbar != null){
            setSupportActionBar(myToolbar);
            myToolbar.setTitle("Upper Body");

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
