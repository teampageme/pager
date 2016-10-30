package com.example.adithya0797.phonebook;

import android.content.Context;
import android.content.Intent;
import android.icu.util.Output;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class homepage extends AppCompatActivity {

    Button bt_open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        bt_open = (Button)findViewById(R.id.bt_open);


        bt_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    OutputStreamWriter ou  = new OutputStreamWriter(getApplicationContext().openFileOutput("contacts.txt", Context.MODE_APPEND));
                    ou.close();
                    Intent it_direct = new Intent(homepage.this, direct.class);
                    startActivity(it_direct);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }



}
