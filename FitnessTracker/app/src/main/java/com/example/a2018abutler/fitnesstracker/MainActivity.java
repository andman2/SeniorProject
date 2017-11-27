package com.example.a2018abutler.fitnesstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton upper = (ImageButton) findViewById(R.id.UpperBody);
        ImageButton lower = (ImageButton) findViewById(R.id.LowerBody);
    }
}
