package com.example.a2018abutler.fitnesstracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class inputActivity extends AppCompatActivity {
    public EditText weightin, repin;
    public Spinner excer;
    public Button ent;
    public int wei;
    public int rep;
    public String ex;
    public Context context;
    public CharSequence text = "Input Weight";
    public CharSequence text2 = "Input Repetitions";
    public CharSequence text3 = "Pick A Lift";
    public CharSequence text4 = "Data Saved";
    public int duration = Toast.LENGTH_SHORT;
    public boolean sp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        context  = getApplicationContext();
        weightin = (EditText) findViewById(R.id.weightin);
        repin = (EditText) findViewById(R.id.repin);
        excer =(Spinner) findViewById(R.id.liftSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lifts_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        excer.setAdapter(adapter);
        excer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ex = getResources().getStringArray(R.array.lifts_array)[position];
                sp = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                sp =false;
            }
        });
        ent = (Button) findViewById(R.id.ent);
        ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp == true) {
                    if (weightin.getText() != null ) {
                        wei = Integer.parseInt(weightin.getText().toString());

                        if (repin.getText() != null ) {
                            rep = Integer.parseInt(repin.getText().toString());
                            calcAndSave(wei,rep,ex);
                            weightin.getText().clear();
                            repin.getText().clear();
                            Toast toast = Toast.makeText(context, text4, duration);
                            toast.show();
                        } else {
                            Toast toast = Toast.makeText(context, text2, duration);
                            toast.show();
                        }
                    } else {
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }

                }
                else{
                    Toast toast = Toast.makeText(context, text3, duration);
                    toast.show();
                }
            }
        });
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (myToolbar != null){
            setSupportActionBar(myToolbar);
            myToolbar.setTitle("Input Data");

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
    public void calcAndSave(int w, int r, String ex){
        int pscore = (int)(w/(1.0278-0.0278 *r));

        Calendar calendar = Calendar.getInstance();
        Date d = calendar.getTime();
        boolean isF = false;
        File directory = getDir("myStuff",MODE_PRIVATE);
        String[] files = getApplicationContext().fileList();
        for (int x = 0; x < files.length; x++){
            if(files[x].equals(ex)){
                isF = true;
                Log.i("does the file exist", isF + "");
            }
        }
        if(isF){
            try {
                String strText = d.toString() + "," +pscore + "\n\r";

                // MODE_APPEND, MODE_WORLD_READABLE, MODE_WORLD_WRITEABLE
                // append to file
                FileOutputStream fos = openFileOutput(ex, getApplicationContext().MODE_APPEND);

                fos.write(strText.getBytes());
                fos.close();
            } catch (IOException e) {
                e.toString();
            }

        }
        else{
            FileOutputStream outputStream;
            String strText = d.toString() + "," +pscore + "\n\r" ;
            try {
                outputStream = openFileOutput(ex, Context.MODE_PRIVATE );
                outputStream.write(strText.getBytes());
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
