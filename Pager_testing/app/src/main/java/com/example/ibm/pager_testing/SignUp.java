package com.example.ibm.pager_testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SignUp extends AppCompatActivity {

    TextView show;
    EditText user;
    int pin;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        user = (EditText)findViewById(R.id.username);
        show = (TextView)findViewById(R.id.show);
        name = String.valueOf(user.getText());



    }

    public void generate(View v){
        //generate a random 9 digit pin
        Random rnd = new Random();
        pin = rnd.nextInt(999999999) + 100000000;

        show.setText("\t Your Username is: " + user + "\n \tyour PIN is:" + pin + "\n");
    }

    public void signup(View v){
        //add to database

    }





}
