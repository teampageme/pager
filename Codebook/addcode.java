package com.example.adithya0797.phonebook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class addcode extends AppCompatActivity {

    Button bt_done;
    EditText et_meaning, et_number;

    TextView tv_confirmmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcode);

        final String filename = getIntent().getExtras().getString("values");

        final String codeadd = et_number.getText().toString() + "\t" + et_meaning.getText().toString();

        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    OutputStreamWriter cd ;
                    cd = new OutputStreamWriter(getApplicationContext().openFileOutput(filename + ".txt", Context.MODE_APPEND));
                    cd.write(String.valueOf(codeadd.getBytes()));
                    cd.close();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                tv_confirmmessage.setText("done");

            }
        });







    }
}
