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
        private TextView errorText;
        private EditText num, pass;
        private String   errormsg = "Incorrect Username/Password, try again";
        private Button   logIn, create;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log_on);

            errorText = (TextView)findViewById(R.id.errorNum);
            num       = (EditText)findViewById(R.id.nineBit);
            pass      = (EditText)findViewById(R.id.pass);
            logIn     = (Button)findViewById(R.id.SingingIN);
            create    = (Button)findViewById(R.id.SingingUP);

            logIn.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    boolean account = true;

                    if (account)//check from server if account exists
                    {
                        //Checks if the 9 bit number does exist in the database, else throw and error
                        if(true)//if (num exists) //its like that just for testing purposes
                        {
                            //change this
                            //setContentView(R.layout.activity_page);
                            //Intent intent = new Intent(log_on.this, encryption.class);
                            //startActivity(intent);
                        }
                        else
                        {
                            errorText.setText(errormsg);
                        }
                    }

                    if(account) //check from the server that the password matches the 9Bit number, then user is redirected to the pager screen
                    {   //else throw an error

                    }
                    else
                    {
                        errorText.setText(errormsg);
                    }
                }
            });

            create.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(log_on.this, sign_up.class);
                    startActivity(intent);
                }
            });
        }
}