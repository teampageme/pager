package com.example.ssk.cse442_sprint2;

import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
//import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText T;
    EditText T2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        T = (EditText) findViewById(R.id.editText);
        T2= (EditText) findViewById(R.id.editText2);
    }
}
