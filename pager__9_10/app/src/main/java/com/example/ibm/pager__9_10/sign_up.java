package com.example.ibm.pager__9_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import java.util.*;
import android.view.View;

public class sign_up extends AppCompatActivity {

    TextView st;
    EditText userid;
    int pin;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);
            userid = (EditText)findViewById(R.id.userid);
            st = (TextView)findViewById(R.id.st);
        }

        public void make_pin(View v){
            //generate a random 9 digit pin
            Random rnd = new Random();
            pin = rnd.nextInt(999999999) + 100000000;

            st.setText("\t Your Username is: " + userid + "\n \tyour PIN is:" + pin + "\n");
        }

        public void add_new_user(View v){
            //add to database

        }





    }

