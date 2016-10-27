package com.example.ibm.PageMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import java.util.*;
import android.view.*;
import android.content.*;
import com.example.ibm.pager__9_10.R;

public class sign_up extends AppCompatActivity
{
    private TextView nineBit, nworked, pworked, eworked;
    private EditText pass, email;
    private int      pin;
    private Button   generate, finish, checkP, checkE;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        pass     = (EditText)findViewById(R.id.ps);
        email    = (EditText)findViewById(R.id.EL);
        nineBit  = (TextView)findViewById(R.id.st);
        nworked  = (TextView)findViewById(R.id.validNum);
        pworked  = (TextView)findViewById(R.id.validPass);
        eworked  = (TextView)findViewById(R.id.validEmail);
        generate = (Button)findViewById(R.id.gen);
        finish   = (Button)findViewById(R.id.fn);
        checkP   = (Button)findViewById(R.id.chkP);
        checkE   = (Button)findViewById(R.id.chkE);

        generate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //needs to check if the generated number is not already been used in the database.
                //after generating a valid number then you can display the 9-bit # to the screen and later send it as an e-mail
                //if valid then use TEXTVIEW "nworked" to say it worked, else then make it say try a different one.
                Random rnd = new Random();
                pin = rnd.nextInt(999999999) + 100000000;
                String test = pass.getText().toString();
                nineBit.setText(test + "" + pin + "");
            }
        });

        checkP.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //checks if the password conditions are met.
                //if valid then use TEXTVIEW "pworked" to say it worked, else then make it say try a different one.
            }
        });

        checkE.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //checks if the e-mail entered conditions are met.
                //if valid then use TEXTVIEW "eworked" to say it worked, else then make it say try a different one.
            }
        });

        finish.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(sign_up.this, page.class);
                startActivity(intent);
            }
        });
    }
}

