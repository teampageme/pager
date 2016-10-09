package com.example.ibm.pager_testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //Log in button action Listener
        Button logIn = (Button)this.findViewById(R.id.Log_in);
        logIn.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(LogIn.this, Paging.class);
                startActivity(intent);
            }
        });
        //Sign up button action Listener
        Button signUp = (Button)this.findViewById(R.id.Sign_up);
        signUp.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}
