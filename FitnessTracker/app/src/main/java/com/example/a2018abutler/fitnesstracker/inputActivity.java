package com.example.a2018abutler.fitnesstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lifts_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        excer.setAdapter(adapter);
    }
}
