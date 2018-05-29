package com.example.a2018abutler.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.List;

public class DisplayLift extends AppCompatActivity {
    public Toolbar myToolbar;
    public GraphView graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lift);
        Intent mIntent = getIntent();
        graph = (GraphView) findViewById(R.id.graph);
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
        String ex = getResources().getStringArray(R.array.lifts_array)[x];
        List<DataPoint> temp = new ArrayList<DataPoint>();

        DataPoint[] points = new DataPoint[temp.size()];
        points = temp.toArray(points);

        if(x==0){
            myToolbar.setTitle("Bench");
            if(isF(ex)){
                
            }
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
    public boolean isF(String ex){
        String[] files = getApplicationContext().fileList();
        for (int x = 0; x < files.length; x++){
            if(files[x].equals(ex)){
                return true;
            }
        }
        return false;
    }
}
