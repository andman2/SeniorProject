package com.example.a2018abutler.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton upper = (ImageButton) findViewById(R.id.UpperBody);//image button to go to lower body workout activity
        ImageButton lower = (ImageButton) findViewById(R.id.LowerBody);//image button to go to lower body workout activity
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (myToolbar != null){
            setSupportActionBar(myToolbar);
            myToolbar.setTitle("bob");

        }
        myToolbar.inflateMenu(R.menu.menu1);
        lower.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(0);
            }

        });
        upper.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchActivity(1);
            }

        });
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
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return false;//super.onOptionsItemSelected(item);

        }
    }
    public void switchActivity(int x){//this method allows us to switch activities (pass 0 for lower body and anything else for upper)
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
