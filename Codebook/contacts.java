package com.example.adithya0797.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.OutputStreamWriter;


import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class contacts extends AppCompatActivity {

    TextView texter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        texter = (TextView)findViewById(R.id.texter);


        try {

            InputStreamReader reader = new InputStreamReader(openFileInput("contacts.txt"));
            BufferedReader buffread = new BufferedReader(reader);

            StringBuffer buff = new StringBuffer();


            while(buffread.readLine()!=null){

                buff.append("");
            }

            texter.setText(buff);




//            RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_contacts);
//            ScrollView scrollView = (ScrollView)findViewById(R.id.scroller);
//            /InputStreamReader reader  = new InputStreamReader(getApplicationContext().openFileInput("contacts.txt"));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
