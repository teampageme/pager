package com.example.ibm.pager_testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Compose extends AppCompatActivity
{
    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
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
    
//     public void back(View v){
//     setContentView(R.layout.choosePIN)
//     }

//     public void back(View v){
//     setContentView(R.layout.ReadMessages)
//     }
}
