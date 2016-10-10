package com.example.ibm.pager__9_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class page extends AppCompatActivity {

        EditText message;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_page);
            message = (EditText)findViewById(R.id.message);

        }

        public void numup(View v){
            int pin = Integer.parseInt(message.getText() + "");


            message.setText(pin + "");

        }

        public void numdown(View v){
            int pin = Integer.parseInt(message.getText() + "");

            message.setText(pin + "");

        }

        public void back(View v){
            setContentView(R.layout.activity_log_on);
        }

        public void front(View v){
            setContentView(R.layout.activity_compose);
        }

        public void send(View v){
            //send the http request to server
        }


    }


