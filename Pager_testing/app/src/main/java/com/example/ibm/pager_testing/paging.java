package com.example.ibm.pager_testing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Compose extends AppCompatActivity
{
    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        number = (EditText)findViewById(R.id.numberType);
        
    }
    
    public void numup(View v){
    int pin = Integer.parseInt(number.getText() + "");
    temp = pin + 1;
    
    number.setText(temp + "");
    
    }
    
    public void numdown(View v){
    int pin = Integer.parseInt(number.getText() + "");
    temp = pin - 1;
    
    number.setText(temp + "");
    
    }
    
    public void back(View v){
    setContentView(R.layout.choosePIN)
    }

    public void front(View v){
    setContentView(R.layout.ReadMessages)
    }

    public void send(View v){
    send the http request to server
    }


}
