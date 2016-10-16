package com.example.ibm.PageMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.view.*;
import android.widget.*;
import com.example.ibm.pager__9_10.R;

public class homepage extends AppCompatActivity
{
    Button login;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        login = (Button)findViewById(R.id.sign_in);
        signUp = (Button)findViewById(R.id.sign_up);

        login.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(homepage.this, log_on.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(homepage.this, sign_up.class);
                startActivity(intent);
            }
        });
    }
}
