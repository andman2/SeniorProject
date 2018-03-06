package com.example.a2018abutler.fitnesstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class UpperBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper_body);
        ImageButton upper = (ImageButton) findViewById(R.id.UpperBody);//image button to go to lower body workout activity
        ImageButton lower = (ImageButton) findViewById(R.id.LowerBody);//image button to go to lower body workout activity
    }
}
