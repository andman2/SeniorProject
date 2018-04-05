package com.example.a2018abutler.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayLift extends AppCompatActivity {
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lift);
        title = (TextView) findViewById(R.id.title);
        Intent mIntent = getIntent();
        int liftnum = mIntent.getIntExtra("liftnum", 0);
        setup(liftnum);
    }
    public void setup(int x){
        if(x==0){
            title.setText("Bench");
            setTitle("bench");
        }
        if(x==1){
            title.setText("Lat Pull Down");
        }
        if(x==2){
            title.setText("Shoulder Press");
        }
        if(x==3){
            title.setText("Pectoral Fly");
        }
        if(x==4){
            title.setText("Bent-over Rows");
        }
        if(x==5){
            title.setText("Bicep Curls");
        }
        if(x==6){
            title.setText("Squat");
        }
        if(x==7){
            title.setText("Dead Lift");
        }
        if(x==8){
            title.setText("Calf Raises");
        }
        if(x==9){
            title.setText("Power Clean");
        }
        if(x==10){
            title.setText("Weighted Lunge");
        }
        if(x==11){
            title.setText("Leg Press");
        }

    }
}
