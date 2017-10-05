package com.google.sdl.decisionhelper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
/**
 * Created by aditya on 21/9/17.
 */
public class Question extends AppCompatActivity implements View.OnClickListener{
    private Button comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(com.google.sdl.decisionhelper.R.layout.question);
        comment=(Button) findViewById(com.google.sdl.decisionhelper.R.id.comment);
        comment.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case com.google.sdl.decisionhelper.R.id.comment:
                startActivity(new Intent(this,Chatting.class));
                break;
        }
    }
}
