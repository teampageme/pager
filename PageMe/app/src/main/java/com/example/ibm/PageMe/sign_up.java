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
    TextView st;
    EditText userid;
    int pin;
    Button generate, finish;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userid = (EditText)findViewById(R.id.userid);
        st = (TextView)findViewById(R.id.st);
        generate = (Button)findViewById(R.id.gen);
        finish = (Button)findViewById(R.id.fn);

        generate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
               /* Intent intent = new Intent(sign_up.this, done.class);
                startActivity(intent);*/
                Random rnd = new Random();
                pin = rnd.nextInt(999999999) + 100000000;
                String test = userid.getText().toString();
                st.setText(test + "" + pin + "");
            }
        });

        finish.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(sign_up.this, done.class);
                    startActivity(intent);
                }
            });
    }
}

