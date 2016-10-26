package com.example.ibm.PageMe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ibm.pager__9_10.R;

public class done extends AppCompatActivity
{

    private TextView input, accomplish;
    private String num;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        input = (TextView)findViewById(R.id.inputted);
        accomplish = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        num = intent.getStringExtra("num");

        input.setText(num);




    }
}
