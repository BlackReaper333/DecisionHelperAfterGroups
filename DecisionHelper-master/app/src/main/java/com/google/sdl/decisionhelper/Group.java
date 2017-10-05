package com.google.sdl.decisionhelper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

/**
 * Created by aditya on 20/9/17.
 */
public class Group extends AppCompatActivity implements View.OnClickListener{

    //declaring variables
    private Toolbar toolbar;
    private RelativeLayout question1;

    private UserObj mUser;


    //firebase declarations
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.google.sdl.decisionhelper.R.layout.group);



        //defining basic variables
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        question1=(RelativeLayout) findViewById(R.id.question1);
        question1.setOnClickListener(this);

        mUser=new UserObj();


        //firebase get the bloody user IMP
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                mUser.uid = profile.getUid();

            };
        }



    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.question1:
                startActivity(new Intent(this,Question.class));
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case com.google.sdl.decisionhelper.R.id.ask_question_menu:
                startActivity(new Intent(this,CreateQuestion.class));
                return true;
            case R.id.group_profile_menu:
                startActivity(new Intent(this,GroupProfile.class));
                return true;
            case R.id.add_participants_menu:
                startActivity(new Intent(this,AddParticipants.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
