package com.google.sdl.decisionhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by aditya on 25/9/17.
 */

public class Settings extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private RelativeLayout linkToProfile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        //defining basic variables
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        linkToProfile=(RelativeLayout) findViewById(R.id.linkToProfile);
        linkToProfile.setOnClickListener(this);


    }




    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main4, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.linkToProfile:
                startActivity(new Intent(this,UserProfile.class));
                break;
        }

    }
}
