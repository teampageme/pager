package com.example.ibm.PageMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;
import com.example.ibm.pager__9_10.R;

public class page extends AppCompatActivity
{

    EditText    message;
    ImageButton Left;
    ImageButton Right;
    ImageButton Up;
    ImageButton Down;
    ImageButton Record;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_page);

            message = (EditText)findViewById(R.id.message);
            Left    = (ImageButton)findViewById(R.id.left);
            Right   = (ImageButton)findViewById(R.id.right);
            Up      = (ImageButton)findViewById(R.id.up);
            Down    = (ImageButton)findViewById(R.id.down);
            Record  = (ImageButton)findViewById(R.id.record);

            Up.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    /*Intent intent = new Intent(homepage.this, log_on.class);
                    startActivity(intent);*/
                    int pin = Integer.parseInt(message.getText() + "");
                    message.setText(pin + "");
                }
            });

            Down.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    /*Intent intent = new Intent(homepage.this, log_on.class);
                    startActivity(intent);*/
                    int pin = Integer.parseInt(message.getText() + "");
                    message.setText(pin + "");
                }
            });
            //int pin = Integer.parseInt(message.getText() + "");
            //message.setText(pin + "");

            Left.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(page.this, log_on.class);
                    startActivity(intent);
                    /*int pin = Integer.parseInt(message.getText() + "");
                    message.setText(pin + "");*/
                }
            });

            Right.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(page.this, compose.class);
                    startActivity(intent);
                    /*int pin = Integer.parseInt(message.getText() + "");
                    message.setText(pin + "");*/
                }
            });
            Record.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(page.this, compose.class);
                    startActivity(intent);
                    /*int pin = Integer.parseInt(message.getText() + "");
                    message.setText(pin + "");*/
                }
            });
    }
}