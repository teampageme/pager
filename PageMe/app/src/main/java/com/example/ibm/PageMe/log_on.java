package com.example.ibm.PageMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import android.content.*;

import com.example.ibm.pager__9_10.R;


public class log_on extends AppCompatActivity
{
        TextView errorText;
        EditText username, pin;
        String errormsg = "Incorrect Username/Password, try again";
        Button logIn, signUp;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log_on);

            errorText = (TextView)findViewById(R.id.error);
            username = (EditText)findViewById(R.id.username);
            pin = (EditText)findViewById(R.id.pin);
            logIn = (Button)findViewById(R.id.takes_to_pager);
            signUp = (Button)findViewById(R.id.redirect_to_sign_up);

            logIn.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    boolean account = true;
                    //check from server if account exists
                    Intent intent = new Intent(log_on.this, page.class);
                    if (account)
                    {
                        if(username == pin)
                        {
                            //change this
                            //setContentView(R.layout.activity_page);
                            startActivity(intent);
                        }
                        else
                        {
                            errorText.setText(errormsg);
                        }
                    }
                    /*else
                    {
                        setContentView(R.layout.activity_sign_up);
                    }*/
                }
            });

            signUp.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(log_on.this, sign_up.class);
                    startActivity(intent);
                }
            });
        }
}