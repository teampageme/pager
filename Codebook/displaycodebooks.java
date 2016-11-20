package com.example.adithya0797.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class displaycodebooks extends AppCompatActivity {

    TextView tv_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaycodebooks);

        tv_display = (TextView)findViewById(R.id.tv_display);

        String name = getIntent().getExtras().getString("key") + ".txt";

        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(openFileInput(name));
            BufferedReader buffread = new BufferedReader(reader);

            StringBuffer codes = new StringBuffer();


            while(buffread.readLine()!=null){

                codes.append("\n" + buffread.readLine() + "\n");
            }
            tv_display.setText(codes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
