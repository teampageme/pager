package com.example.ibm.pager__9_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.*;


public class log_on extends AppCompatActivity {
    TextView errorText;
    EditText username, pin;
        String errormsg = "Incorrect Username/Password, try again";
        Button logIn;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log_on);

            errorText = (TextView)findViewById(R.id.error);
            username = (EditText)findViewById(R.id.username);

            pin = (EditText)findViewById(R.id.pin);


        }



        public void signIn(View v){

            boolean account = true;
            //check from server if account exists
            if (account){
                if(username == pin){
                    //change this
                    setContentView(R.layout.activity_page);

                }
                else{
                    errorText.setText(errormsg);
                }


            }
            else{
                setContentView(R.layout.activity_sign_up);
            }









        }

        public void signUp(View v){
            setContentView(R.layout.activity_sign_up);
        }

    }

