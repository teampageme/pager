package com.example.ibm.pager__9_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;


public class HomePage extends AppCompatActivity{

    Button login;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        login = (Button)findViewById(R.id.sign_in);
        signUp = (Button)findViewById(R.id.sign_up);



    }


    public void in(View v){
        setContentView(R.layout.activity_log_on);


    }

    public void up(View v){
        setContentView(R.layout.activity_sign_up);


    }

}
