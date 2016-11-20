package com.example.adithya0797.phonebook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class addcontact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);

        Button submit;
        final EditText name;
        final EditText pin;
        final TextView tv_confirm;


        submit = (Button)findViewById(R.id.submit);
        name = (EditText)findViewById(R.id.name);
        pin = (EditText)findViewById(R.id.PIN);
        tv_confirm = (TextView)findViewById(R.id.tv_confirm);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newname = pin.getText().toString();
                String names = name.getText().toString();
                String temp = names + "\t" + newname;


                try{
                OutputStreamWriter ct ;
                    ct = new OutputStreamWriter(getApplicationContext().openFileOutput("contacts.txt", Context.MODE_APPEND));
                    ct.write(String.valueOf(temp.getBytes()));
                    ct.close();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//
//
//
//
                OutputStreamWriter  code;
                try {
                    code = new OutputStreamWriter(getApplicationContext().openFileOutput(newname + ".txt", Context.MODE_APPEND));
                    code.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                tv_confirm.setText("Done");





            }
        });}
}
