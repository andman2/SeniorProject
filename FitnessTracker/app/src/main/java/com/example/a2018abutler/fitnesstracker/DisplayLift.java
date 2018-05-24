package com.example.a2018abutler.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayLift extends AppCompatActivity {
    public Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lift);
        Intent mIntent = getIntent();
        int liftnum = mIntent.getIntExtra("liftnum", 0);
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if (myToolbar != null){
            setSupportActionBar(myToolbar);
            myToolbar.setTitle("Upper Body");

        }
        myToolbar.inflateMenu(R.menu.menu1);
        setup(liftnum);
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
    public void setup(int x){
        if(x==0){
            myToolbar.setTitle("Bench");
            setTitle("bench");
        }
        if(x==1){
            myToolbar.setTitle("Lat Pull Down");
        }
        if(x==2){
            myToolbar.setTitle("Shoulder Press");
        }
        if(x==3){
            myToolbar.setTitle("Pectoral Fly");
        }
        if(x==4){
            myToolbar.setTitle("Bent-over Rows");
        }
        if(x==5){
            myToolbar.setTitle("Bicep Curls");
        }
        if(x==6){
            myToolbar.setTitle("Squat");
        }
        if(x==7){
            myToolbar.setTitle("Dead Lift");
        }
        if(x==8){
            myToolbar.setTitle("Calf Raises");
        }
        if(x==9){
            myToolbar.setTitle("Power Clean");
        }
        if(x==10){
            myToolbar.setTitle("Weighted Lunge");
        }
        if(x==11){
            myToolbar.setTitle("Leg Press");
        }

    }
}
