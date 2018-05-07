package com.example.a2018abutler.fitnesstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class inputActivity extends AppCompatActivity {
    public EditText weightin, repin;
    public Spinner excer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        weightin = (EditText) findViewById(R.id.weightin);
        repin = (EditText) findViewById(R.id.repin);
        excer =(Spinner) findViewById(R.id.liftSpinner);

    }
}
