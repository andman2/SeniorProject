package com.example.a2018abutler.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton upper = (ImageButton) findViewById(R.id.UpperBody);
        ImageButton lower = (ImageButton) findViewById(R.id.LowerBody);//image button to go to lower body workout activity

        lower.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(0);
            }

        });
    }
    public void switchActivity(int x){//this method allows usd to switch activities (pass 0 for lower body and anything else for upper)
        Intent intent;
        if (x == 0){
            intent = new Intent(this, LowerBody.class);
        }
        else {
            intent = new Intent(this, UpperBody.class);
        }
        startActivity(intent);
    }
}
